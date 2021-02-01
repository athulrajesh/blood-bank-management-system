package com.bms.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_BMS")
public class OrderModel {
	
	@Id
	@SequenceGenerator(name="seq",sequenceName="order_id_seq", allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq") 
	
    private Integer order_id;
	
	@Column(name="B_GROUP")
	private String bg;
	
	@Column(name="AMOUNT")
	private float amount;
	 @Column(name="TIME")
	 private Timestamp time;
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getBg() {
		return bg;
	}
	public void setBg(String bg) {
		this.bg = bg;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.time = timestamp;
	}
	 
	 
	

}
