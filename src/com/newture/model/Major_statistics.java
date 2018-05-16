package com.newture.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="major_statistics")
public class Major_statistics implements Serializable {

	private static final long serialVersionUID = -5466316898333173354L;
	
	@Id													//指定主键
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payablemoney_seq")  
	@SequenceGenerator(name="payablemoney_seq", sequenceName="seq_majors",allocationSize=1,initialValue=1)
	private int id;
	
	@Column(name = "resultscore", length=50,unique=true)
	private String resultscore;
	
	@Column(name = "lot", length=50,unique=true)
	private String lot;
	
	@ManyToOne(cascade = {CascadeType.ALL},optional = true,fetch = FetchType.EAGER)
	private Course course;
	
	@ManyToOne(cascade = {CascadeType.ALL},optional = true,fetch = FetchType.EAGER)
	private Users users;
	
	@ManyToOne(cascade = {CascadeType.ALL},optional = true,fetch = FetchType.EAGER)
	private Classes classes;
	
	@ManyToOne(cascade = {CascadeType.ALL},optional = true,fetch = FetchType.EAGER)
	private Feenback_item feenback_item;
	
	public Feenback_item getFeenback_item() {
		return feenback_item;
	}

	public void setFeenback_item(Feenback_item feenback_item) {
		this.feenback_item = feenback_item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResultscore() {
		return resultscore;
	}

	public void setResultscore(String resultscore) {
		this.resultscore = resultscore;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
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
	
}
