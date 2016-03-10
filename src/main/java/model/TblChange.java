package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the tblChange database table.
 * 
 */
@Entity
@NamedQuery(name="TblChange.findAll", query="SELECT t FROM TblChange t")
public class TblChange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private double change_ID;

	private byte affectedIncident;

	private Time avbTime;

	@Column(name="fixed_cost")
	private double fixedCost;

	private Time incidentFreq;

	private byte isActive;

	private byte isApplied;

	private Time rcmdTime;

	@Column(name="varient_income")
	private double varientIncome;

	//bi-directional many-to-many association to TblChange
	@ManyToMany
	@JoinTable(
		name="tblAffected_Change"
		, joinColumns={
			@JoinColumn(name="affected")
			}
		, inverseJoinColumns={
			@JoinColumn(name="affecting")
			}
		)
	private List<TblChange> tblChanges1;

	//bi-directional many-to-many association to TblChange
	@ManyToMany(mappedBy="tblChanges1")
	private List<TblChange> tblChanges2;

	//bi-directional many-to-one association to TblCI
	@ManyToOne
	@JoinColumn(name="CI_ID")
	private TblCI tblCi;

	public TblChange() {
	}

	public double getChange_ID() {
		return this.change_ID;
	}

	public void setChange_ID(double change_ID) {
		this.change_ID = change_ID;
	}

	public byte getAffectedIncident() {
		return this.affectedIncident;
	}

	public void setAffectedIncident(byte affectedIncident) {
		this.affectedIncident = affectedIncident;
	}

	public Time getAvbTime() {
		return this.avbTime;
	}

	public void setAvbTime(Time avbTime) {
		this.avbTime = avbTime;
	}

	public double getFixedCost() {
		return this.fixedCost;
	}

	public void setFixedCost(double fixedCost) {
		this.fixedCost = fixedCost;
	}

	public Time getIncidentFreq() {
		return this.incidentFreq;
	}

	public void setIncidentFreq(Time incidentFreq) {
		this.incidentFreq = incidentFreq;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsApplied() {
		return this.isApplied;
	}

	public void setIsApplied(byte isApplied) {
		this.isApplied = isApplied;
	}

	public Time getRcmdTime() {
		return this.rcmdTime;
	}

	public void setRcmdTime(Time rcmdTime) {
		this.rcmdTime = rcmdTime;
	}

	public double getVarientIncome() {
		return this.varientIncome;
	}

	public void setVarientIncome(double varientIncome) {
		this.varientIncome = varientIncome;
	}

	public List<TblChange> getTblChanges1() {
		return this.tblChanges1;
	}

	public void setTblChanges1(List<TblChange> tblChanges1) {
		this.tblChanges1 = tblChanges1;
	}

	public List<TblChange> getTblChanges2() {
		return this.tblChanges2;
	}

	public void setTblChanges2(List<TblChange> tblChanges2) {
		this.tblChanges2 = tblChanges2;
	}

	public TblCI getTblCi() {
		return this.tblCi;
	}

	public void setTblCi(TblCI tblCi) {
		this.tblCi = tblCi;
	}

}