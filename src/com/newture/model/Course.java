package com.newture.model;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="course")
public class Course implements java.io.Serializable{

	private static final long serialVersionUID = 4905603792679026782L;
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payablemoney_seq")  //生成策略
	@SequenceGenerator(name="payablemoney_seq", sequenceName="seq_Course",allocationSize=1,initialValue=1)
	private int id;
	
	@Column(name = "coursename", length=50,unique=false)
	private String coursename;
	
	@Column(name = "statu", length=50,unique=false)
	private int statu;
	
	@Column(name = "coursetype", length=50,unique=false)
	private int coursetype;
	
	@OneToMany(mappedBy="course",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	private Set<Class_schedule> classchedule = new HashSet<Class_schedule>();
	
	@OneToMany(mappedBy="course",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	private Set<Feenbackscore> feenbackscore = new HashSet<Feenbackscore>();
	
	@OneToMany(mappedBy="course",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	private Set<Major_statistics> major_statistics = new HashSet<Major_statistics>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public int getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(int coursetype) {
		this.coursetype = coursetype;
	}

	public Set<Class_schedule> getClasschedule() {
		return classchedule;
	}

	public void setClasschedule(Set<Class_schedule> classchedule) {
		this.classchedule = classchedule;
	}

	public Set<Feenbackscore> getFeenbackscore() {
		return feenbackscore;
	}

	public void setFeenbackscore(Set<Feenbackscore> feenbackscore) {
		this.feenbackscore = feenbackscore;
	}

	public Set<Major_statistics> getMajor_statistics() {
		return major_statistics;
	}

	public void setMajor_statistics(Set<Major_statistics> major_statistics) {
		this.major_statistics = major_statistics;
	}
}
