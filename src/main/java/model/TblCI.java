package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblCI database table.
 * 
 */
@Entity
@NamedQuery(name="TblCI.findAll", query="SELECT t FROM TblCI t")
public class TblCI implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte service_ID;

	@Temporal(TemporalType.DATE)
	@Column(name="delivary_time")
	private Date delivaryTime;

	private int event_ID;

	@Column(name="fixed_cost")
	private double fixedCost;

	@Column(name="fixed_income")
	private double fixedIncome;

	private byte isActive;

	private byte isTechnical;

	private byte priority;

	@Column(name="service_code")
	private String serviceCode;

	@Column(name="service_name")
	private String serviceName;

	private int solution_A;

	private int solution_B;

	@Column(name="supplier_level2")
	private String supplierLevel2;

	@Column(name="supplier_level3")
	private String supplierLevel3;

	//bi-directional many-to-one association to TblAffected_CI
	@OneToMany(mappedBy="tblCi")
	private List<TblAffected_CI> tblAffectedCis;

	//bi-directional many-to-one association to TblCI_Department
	@OneToMany(mappedBy="tblCi")
	private List<TblCI_Department> tblCiDepartments;

	//bi-directional many-to-one association to TblCI_Division
	@OneToMany(mappedBy="tblCi")
	private List<TblCI_Division> tblCiDivisions;

	//bi-directional many-to-one association to TblChange
	@OneToMany(mappedBy="tblCi")
	private List<TblChange> tblChanges;

	//bi-directional many-to-one association to TblResource_CI
	@OneToMany(mappedBy="tblCi")
	private List<TblResource_CI> tblResourceCis;

	public TblCI() {
	}

	public byte getService_ID() {
		return this.service_ID;
	}

	public void setService_ID(byte service_ID) {
		this.service_ID = service_ID;
	}

	public Date getDelivaryTime() {
		return this.delivaryTime;
	}

	public void setDelivaryTime(Date delivaryTime) {
		this.delivaryTime = delivaryTime;
	}

	public int getEvent_ID() {
		return this.event_ID;
	}

	public void setEvent_ID(int event_ID) {
		this.event_ID = event_ID;
	}

	public double getFixedCost() {
		return this.fixedCost;
	}

	public void setFixedCost(double fixedCost) {
		this.fixedCost = fixedCost;
	}

	public double getFixedIncome() {
		return this.fixedIncome;
	}

	public void setFixedIncome(double fixedIncome) {
		this.fixedIncome = fixedIncome;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsTechnical() {
		return this.isTechnical;
	}

	public void setIsTechnical(byte isTechnical) {
		this.isTechnical = isTechnical;
	}

	public byte getPriority() {
		return this.priority;
	}

	public void setPriority(byte priority) {
		this.priority = priority;
	}

	public String getServiceCode() {
		return this.serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getSolution_A() {
		return this.solution_A;
	}

	public void setSolution_A(int solution_A) {
		this.solution_A = solution_A;
	}

	public int getSolution_B() {
		return this.solution_B;
	}

	public void setSolution_B(int solution_B) {
		this.solution_B = solution_B;
	}

	public String getSupplierLevel2() {
		return this.supplierLevel2;
	}

	public void setSupplierLevel2(String supplierLevel2) {
		this.supplierLevel2 = supplierLevel2;
	}

	public String getSupplierLevel3() {
		return this.supplierLevel3;
	}

	public void setSupplierLevel3(String supplierLevel3) {
		this.supplierLevel3 = supplierLevel3;
	}

	public List<TblAffected_CI> getTblAffectedCis() {
		return this.tblAffectedCis;
	}

	public void setTblAffectedCis(List<TblAffected_CI> tblAffectedCis) {
		this.tblAffectedCis = tblAffectedCis;
	}

	public TblAffected_CI addTblAffectedCi(TblAffected_CI tblAffectedCi) {
		getTblAffectedCis().add(tblAffectedCi);
		tblAffectedCi.setTblCi(this);

		return tblAffectedCi;
	}

	public TblAffected_CI removeTblAffectedCi(TblAffected_CI tblAffectedCi) {
		getTblAffectedCis().remove(tblAffectedCi);
		tblAffectedCi.setTblCi(null);

		return tblAffectedCi;
	}

	public List<TblCI_Department> getTblCiDepartments() {
		return this.tblCiDepartments;
	}

	public void setTblCiDepartments(List<TblCI_Department> tblCiDepartments) {
		this.tblCiDepartments = tblCiDepartments;
	}

	public TblCI_Department addTblCiDepartment(TblCI_Department tblCiDepartment) {
		getTblCiDepartments().add(tblCiDepartment);
		tblCiDepartment.setTblCi(this);

		return tblCiDepartment;
	}

	public TblCI_Department removeTblCiDepartment(TblCI_Department tblCiDepartment) {
		getTblCiDepartments().remove(tblCiDepartment);
		tblCiDepartment.setTblCi(null);

		return tblCiDepartment;
	}

	public List<TblCI_Division> getTblCiDivisions() {
		return this.tblCiDivisions;
	}

	public void setTblCiDivisions(List<TblCI_Division> tblCiDivisions) {
		this.tblCiDivisions = tblCiDivisions;
	}

	public TblCI_Division addTblCiDivision(TblCI_Division tblCiDivision) {
		getTblCiDivisions().add(tblCiDivision);
		tblCiDivision.setTblCi(this);

		return tblCiDivision;
	}

	public TblCI_Division removeTblCiDivision(TblCI_Division tblCiDivision) {
		getTblCiDivisions().remove(tblCiDivision);
		tblCiDivision.setTblCi(null);

		return tblCiDivision;
	}

	public List<TblChange> getTblChanges() {
		return this.tblChanges;
	}

	public void setTblChanges(List<TblChange> tblChanges) {
		this.tblChanges = tblChanges;
	}

	public TblChange addTblChange(TblChange tblChange) {
		getTblChanges().add(tblChange);
		tblChange.setTblCi(this);

		return tblChange;
	}

	public TblChange removeTblChange(TblChange tblChange) {
		getTblChanges().remove(tblChange);
		tblChange.setTblCi(null);

		return tblChange;
	}

	public List<TblResource_CI> getTblResourceCis() {
		return this.tblResourceCis;
	}

	public void setTblResourceCis(List<TblResource_CI> tblResourceCis) {
		this.tblResourceCis = tblResourceCis;
	}

	public TblResource_CI addTblResourceCi(TblResource_CI tblResourceCi) {
		getTblResourceCis().add(tblResourceCi);
		tblResourceCi.setTblCi(this);

		return tblResourceCi;
	}

	public TblResource_CI removeTblResourceCi(TblResource_CI tblResourceCi) {
		getTblResourceCis().remove(tblResourceCi);
		tblResourceCi.setTblCi(null);

		return tblResourceCi;
	}

}