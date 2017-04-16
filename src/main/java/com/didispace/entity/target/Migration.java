package com.didispace.entity.target;

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
@Table(name = "Migration")
public class Migration {

	@Id
	private Long id;
	private Date createTime;
	private String tableName;
	private int pageNum;
	private int pageSize;
	private String statrId;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatrId() {
		return statrId;
	}

	public void setStatrId(String statrId) {
		this.statrId = statrId;
	}
}
