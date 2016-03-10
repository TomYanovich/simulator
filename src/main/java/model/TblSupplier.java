package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblSupplier database table.
 * 
 */
@Entity
@NamedQuery(name="TblSupplier.findAll", query="SELECT t FROM TblSupplier t")
public class TblSupplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="supplier_name")
	private String supplierName;

	private byte isActive;

	@Column(name="solution_cost")
	private double solutionCost;

	//bi-directional many-to-one association to TblService
	@OneToMany(mappedBy="tblSupplier1")
	private List<TblService> tblServices1;

	//bi-directional many-to-one association to TblService
	@OneToMany(mappedBy="tblSupplier2")
	private List<TblService> tblServices2;

	public TblSupplier() {
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public double getSolutionCost() {
		return this.solutionCost;
	}

	public void setSolutionCost(double solutionCost) {
		this.solutionCost = solutionCost;
	}

	public List<TblService> getTblServices1() {
		return this.tblServices1;
	}

	public void setTblServices1(List<TblService> tblServices1) {
		this.tblServices1 = tblServices1;
	}

	public TblService addTblServices1(TblService tblServices1) {
		getTblServices1().add(tblServices1);
		tblServices1.setTblSupplier1(this);

		return tblServices1;
	}

	public TblService removeTblServices1(TblService tblServices1) {
		getTblServices1().remove(tblServices1);
		tblServices1.setTblSupplier1(null);

		return tblServices1;
	}

	public List<TblService> getTblServices2() {
		return this.tblServices2;
	}

	public void setTblServices2(List<TblService> tblServices2) {
		this.tblServices2 = tblServices2;
	}

	public TblService addTblServices2(TblService tblServices2) {
		getTblServices2().add(tblServices2);
		tblServices2.setTblSupplier2(this);

		return tblServices2;
	}

	public TblService removeTblServices2(TblService tblServices2) {
		getTblServices2().remove(tblServices2);
		tblServices2.setTblSupplier2(null);

		return tblServices2;
	}

}