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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * 指标类别
 * @author Administrator
 *
 */
@Entity	//指定实体类和对应表的名称
@Table(name="feenback")
public class Feenback implements java.io.Serializable{
	
	private static final long serialVersionUID = -3957309199633381668L;
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payablemoney_seq")  
	@SequenceGenerator(name="payablemoney_seq", sequenceName="seq_feenback",allocationSize=1,initialValue=1)
	private int feenback_id;//id
	@Column(name = "feenback_name", length=50,unique=true)
	private String feenback_name;//类名
	
	@OneToMany(mappedBy="feenback",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Set<Feenback_item> feenback_item = new HashSet<Feenback_item>();
	
	@ManyToMany(targetEntity = Class_schedule.class, fetch = FetchType.EAGER)  
	@JoinTable(name = "classschedule_feenback", joinColumns = @JoinColumn(name = "feenback_id"), inverseJoinColumns = @JoinColumn(name = "id"))  
	private Set<Class_schedule> classchedule = new HashSet<Class_schedule>();;
	
	public Set<Feenback_item> getFeenback_item() {
		return feenback_item;
	}
	public void setFeenback_item(Set<Feenback_item> feenback_item) {
		this.feenback_item = feenback_item;
	}
	
	public Set<Class_schedule> getClasschedule() {
		return classchedule;
	}
	public void setClasschedule(Set<Class_schedule> classchedule) {
		this.classchedule = classchedule;
	}
	public int getFeenback_id() {
		return feenback_id;
	}

	public void setFeenback_id(int feenback_id) {
		this.feenback_id = feenback_id;
	}

	public String getFeenback_name() {
		return feenback_name;
	}

	public void setFeenback_name(String feenback_name) {
		this.feenback_name = feenback_name;
	}

}
