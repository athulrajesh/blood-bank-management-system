package com.bms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BLOOD_GROUP")
public class BloodGroupModel {
	@Id
	@Column(name="ID")
	private int id;
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BloodGroupModel [id=" + id + ", aPos=" + aPos + ", bPos=" + bPos + ", oPos=" + oPos + ", abPos=" + abPos
				+ ", aNeg=" + aNeg + ", bNeg=" + bNeg + ", oNeg=" + oNeg + ", abNeg=" + abNeg + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="A_POSITIVE")
	private float aPos;
	
	@Column(name="B_POSITIVE")
	private float bPos;
	
	@Column(name="O_POSITIVE")
	private float oPos;
	
	@Column(name="AB_POSITIVE")
	private float abPos;
	
	@Column(name="A_NEGATIVE")
	private float aNeg;
	
	@Column(name="B_NEGATIVE")
	private float bNeg;
	
	@Column(name="O_NEGATIVE")
	private float oNeg;
	
	@Column(name="AB_NEGATIVE")
	private float abNeg;

	public float getaPos() {
		return aPos;
	}

	public void setaPos(float aPos) {
		this.aPos = aPos;
	}

	public float getbPos() {
		return bPos;
	}

	public void setbPos(float bPos) {
		this.bPos = bPos;
	}

	public float getoPos() {
		return oPos;
	}

	public void setoPos(float oPos) {
		this.oPos = oPos;
	}

	public float getAbPos() {
		return abPos;
	}

	public void setAbPos(float abPos) {
		this.abPos = abPos;
	}

	public float getaNeg() {
		return aNeg;
	}

	public void setaNeg(float aNeg) {
		this.aNeg = aNeg;
	}

	public float getbNeg() {
		return bNeg;
	}

	public void setbNeg(float bNeg) {
		this.bNeg = bNeg;
	}

	public float getoNeg() {
		return oNeg;
	}

	public void setoNeg(float oNeg) {
		this.oNeg = oNeg;
	}

	public float getAbNeg() {
		return abNeg;
	}

	public void setAbNeg(float abNeg) {
		this.abNeg = abNeg;
	}

}
