package com.didispace.entity.source;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 源数据库中的Bean
 * 此源程序由码农知道提供
 * @author 山人
 *
 */
@Entity
@Table(name = "t_alarm")
public class Alarm {

	private Date FIRST_OCCURENCE;
	private String DEVICE_ID;
	@Id
	private String ID;
	public Alarm() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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
