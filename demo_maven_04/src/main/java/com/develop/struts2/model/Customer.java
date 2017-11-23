package com.develop.struts2.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblCustomerType")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	 
	 @Id  
	 @Column(name = "type_id")
	 private String typeId;
	 @Column(name="type_name")
	 private String typeName;
	 @Column(name="description")
	 private String description;
	 @Column(name="record_stat")
	 private String recordStat;
	 
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRecordStat() {
		return recordStat;
	}
	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}
	 
	 
}
