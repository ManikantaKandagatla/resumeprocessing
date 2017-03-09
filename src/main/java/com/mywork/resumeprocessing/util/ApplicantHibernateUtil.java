/**
 * @author ManiKanta Kandagatla
 */
package com.mywork.resumeprocessing.util;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mywork.resumeprocessing.model.EmpProfile;
import com.mywork.resumeprocessing.model.EmpProjects;
import com.mywork.resumeprocessing.model.EmpResume;


@Repository
@Transactional
public class HibernateUtil {
	
	private static final Logger log = LoggerFactory.getLogger(HibernateUtil.class);
	@Autowired
	private SessionFactory sessionFactory;
	public boolean create(Object entity,List<EmpProjects> projects,EmpResume resumeobj) 
	{
		EmpProfile emp = (EmpProfile)entity;
		Session session = sessionFactory.getCurrentSession();
		try
		{
			session.persist(emp);
	        for ( int i=0; i<projects.size(); i++ )
	        {
	           session.persist(projects.get(i));
	        }
	        session.persist(resumeobj);
	        return true;
	    }
		catch (Exception e) 
		{
			e.printStackTrace(); 
			return false;
	       
	    }
		finally 
		{
	       
	    }
	} 
	
	
	 @SuppressWarnings("unchecked")
	 public List<EmpProfile> fetchAll() 
	 {
		 log.info("Retrieving all Applicants..!!");
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpProfile.class);
		 List<EmpProfile> empProfiles = null;
		 try
		 {
			 empProfiles = (List<EmpProfile>)criteria.list();;
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return empProfiles;
	 }
	 
	 public void deleteEmployeeByid(String id) 
	 {
		 Query query = sessionFactory.getCurrentSession().createSQLQuery("delete from EmpProjects where contact = :contact");
		 query.setString("contact", id);
		 query.executeUpdate();
		 query = sessionFactory.getCurrentSession().createSQLQuery("delete from Empresume where contact = :contact");
		 query.setString("contact", id);
		 query.executeUpdate();
		 query = sessionFactory.getCurrentSession().createSQLQuery("delete from EmpProfile where contact = :contact");
		 query.setString("contact", id);
		 query.executeUpdate();
	 }
	 	
	 @SuppressWarnings("unchecked")
	 public List<EmpProfile> search(String property,String value)
	 {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpProfile.class);
		criteria.add(Restrictions.like(property, value, MatchMode.ANYWHERE));
		List<EmpProfile> empProfiles = null;
		try
		{
			empProfiles = (List<EmpProfile>)criteria.list();;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return  empProfiles;
	}
	 
	 public EmpProfile getEmployee(String contact)
	 {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpProfile.class);
		criteria.add(Restrictions.eq("contact", contact));
		EmpProfile empProfile = null;
		try
		{
			empProfile = (EmpProfile) criteria.uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return  empProfile;
	 }
	 
	 
	 public EmpResume getEmployeeResume(String contact)
	 {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpResume.class,"empresume");
		criteria.createAlias("empresume.empprofile","empprofile");
		criteria.add(Restrictions.eq("empprofile.contact", contact));
		return  (EmpResume) criteria.uniqueResult();
	 }

	 @SuppressWarnings("unchecked")
	public List<EmpProjects> fetchprojects(String contact) 
	{
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpProjects.class);
		criteria.add(Restrictions.eq("contact", contact));
		List<EmpProjects> listEmpProjects = null;
		try
		{
			listEmpProjects = (List<EmpProjects>) criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listEmpProjects;
	}

	/*public void storeResume(EmpResume resume) 
	{
		Session session = sessionFactory.openSession();
		try
		{
			log.info("Adding resume object");
			log.debug("i am here..");
			session.save(resume);
			log.info("Added resume object");
			log.debug("i am here..");
		}
		catch(Exception e)
		{
			log.error("Exception adding resume object: "+ e);
		}
		finally
		{
			session.close();
		}
	}*/
}
