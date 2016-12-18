package com.mywork.resumeprocessing.model;
/**
 * @author ManiKanta Kandagatla
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmpResume")
public class EmpResume {
	
	

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column
	private String contact;
	
	@Column
	private byte[] empresume;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	public byte[] getEmpresume() {
		return empresume;
	}

	public void setEmpresume(byte[] empresume) {
		this.empresume = empresume;
	}


}
