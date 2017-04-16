package com.didispace.entity.target;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "alarm")
public class Alarm {

	private Date FIRST_OCCURENCE;
	private String DEVICE_ID;
	@Id
	private Long id;
	public Alarm() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFIRST_OCCURENCE() {
		return FIRST_OCCURENCE;
	}

	public void setFIRST_OCCURENCE(Date FIRST_OCCURENCE) {
		this.FIRST_OCCURENCE = FIRST_OCCURENCE;
	}

	public String getDEVICE_ID() {
		return DEVICE_ID;
	}

	public void setDEVICE_ID(String DEVICE_ID) {
		this.DEVICE_ID = DEVICE_ID;
	}
}
