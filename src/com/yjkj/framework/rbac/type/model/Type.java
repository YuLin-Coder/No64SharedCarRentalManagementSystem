package com.yjkj.framework.rbac.type.model;

import java.math.BigDecimal;

import com.yjkj.framework.base.basemodel.BaseModel;


public class Type extends BaseModel{
	
	private BigDecimal sale;
	private String typee;
	private String remark;
	private Integer price;
	private String name;
	private Type type;
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public BigDecimal getSale() {
		return sale;
	}
	public void setSale(BigDecimal sale) {
		this.sale = sale;
	}
	public String getTypee() {
		return typee;
	}
	public void setTypee(String typee) {
		this.typee = typee;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
