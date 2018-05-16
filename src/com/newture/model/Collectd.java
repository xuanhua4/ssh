package com.newture.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity(name="collect")
public class Collectd {
	@Id													//指定主键
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payablemoney_seq")  
	@SequenceGenerator(name="payablemoney_seq", sequenceName="seq_collect",allocationSize=1,initialValue=1)
	private Integer collectId;
	
	@Column(name = "classname", length=50,unique=true)
	private Integer type;
	
	@Column(name = "name", length=50,unique=true)
	private String name;
	
	@Column(name = "score",unique=true)
	private Integer score;
	
	@Column(name = "lot", length=50,unique=true)
	private int lot;
	
	@ManyToOne(cascade = {CascadeType.ALL},optional = true,fetch = FetchType.EAGER)
	private Feenback_item feenback_item;

	public Integer getCollectId() {
		return collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public Feenback_item getFeenback_item() {
		return feenback_item;
	}

	public void setFeenback_item(Feenback_item feenback_item) {
		this.feenback_item = feenback_item;
	}
	
	
	
}
