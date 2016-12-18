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

import com.mywork.resumeprocessing.model.EmpProfile;
import com.mywork.resumeprocessing.model.EmpProjects;
import com.mywork.resumeprocessing.model.EmpResume;


@Repository
@Transactional
public class HibernateUtil {
	
	@Autowired
	private SessionFactory sessionFactory;
	public void create(Object entity,List<EmpProjects> projects) {
		
		EmpProfile emp = (EmpProfile)entity;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(emp);
	         for ( int i=0; i<projects.size(); i++ )
	         {
	            session.save(projects.get(i));
	         }
	         tx.commit();
	      }
		catch (HibernateException e) {
	    	 if (tx!=null) 
	    		 tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	} 
	
	
	 @SuppressWarnings("unchecked")
	 public List<EmpProfile> fetchAll() {
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpProfile.class);
		 return (List<EmpProfile>) criteria.list();
	 }
	 
	 public void deleteEmployeeByid(String id) {
		 Query query = sessionFactory.getCurrentSession().createSQLQuery("delete from EmpProjects where contact = :contact");
		 query.setString("contact", id);
		 query.executeUpdate();
		 query = sessionFactory.getCurrentSession().createSQLQuery("delete from EmpProfile where contact = :contact");
		 query.setString("contact", id);
		 query.executeUpdate();
		 query = sessionFactory.getCurrentSession().createSQLQuery("delete from Empresume where contact = :contact");
		 query.setString("contact", id);
		 query.executeUpdate();
		 
	 }
	 	
	 
	 @SuppressWarnings("unchecked")
	 public List<EmpProfile> search(String property,String value) {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpProfile.class);
			criteria.add(Restrictions.like(property, value, MatchMode.ANYWHERE));
			return (List<EmpProfile>) criteria.list();
	}
	 
	 public EmpProfile getEmployee(String contact)
	 {
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpProfile.class);
			criteria.add(Restrictions.eq("contact", contact));
		    return  (EmpProfile) criteria.uniqueResult();
	 }
	 
	 
	 public EmpResume getEmployeeResume(String contact)
	 {
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpResume.class);
			criteria.add(Restrictions.eq("contact", contact));
		    return  (EmpResume) criteria.uniqueResult();
	 }

	 @SuppressWarnings("unchecked")
	public List<EmpProjects> fetchprojects(String contact) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmpProjects.class);
		criteria.add(Restrictions.eq("contact", contact));
		return  (List<EmpProjects>) criteria.list();
	}


	public void storeResume(EmpResume resume) {
		sessionFactory.getCurrentSession().save(resume);
	}
	
	
	 
}
