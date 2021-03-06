package com.newture.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="class_schedule")
public class Class_schedule implements java.io.Serializable{

	private static final long serialVersionUID = -1876865188714937182L;
	
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payablemoney_seq")  
	@SequenceGenerator(name="payablemoney_seq", sequenceName="seq_Class_schedule",allocationSize=1,initialValue=1)
	private int id;
	
	@Column(name = "statu", unique=false)
	private int statu;
	
	@ManyToOne(cascade = {CascadeType.ALL},optional = true,fetch = FetchType.EAGER)
	private Course course;
	
	@ManyToOne(cascade = {CascadeType.ALL},optional = true,fetch = FetchType.EAGER)
	private Users users;
	
	@ManyToOne(cascade = {CascadeType.ALL},optional = true,fetch = FetchType.EAGER)
	private Classes classes;
	
	@OneToMany(mappedBy="classchedule",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Set<Fb_time> fb_time = new HashSet<Fb_time>();
	
	@ManyToMany(mappedBy = "classchedule", targetEntity = Feenback.class,fetch = FetchType.EAGER)
	private Set<Feenback> feenback = new HashSet<Feenback>();
	
	@Column(name = "lot", unique=false)
	private String lot;
	

	public Set<Feenback> getFeenback() {
		return feenback;
	}

	public void setFeenback(Set<Feenback> feenback) {
		this.feenback = feenback;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Set<Fb_time> getFb_time() {
		return fb_time;
	}

	public void setFb_time(Set<Fb_time> fb_time) {
		this.fb_time = fb_time;
	}
	
}
