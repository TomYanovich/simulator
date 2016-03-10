package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblResource database table.
 * 
 */
@Entity
@NamedQuery(name="TblResource.findAll", query="SELECT t FROM TblResource t")
public class TblResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String resourceName;

	private double pricePerUnit;

	//bi-directional many-to-one association to TblResource_CI
	@OneToMany(mappedBy="tblResource")
	private List<TblResource_CI> tblResourceCis;

	public TblResource() {
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public double getPricePerUnit() {
		return this.pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public List<TblResource_CI> getTblResourceCis() {
		return this.tblResourceCis;
	}

	public void setTblResourceCis(List<TblResource_CI> tblResourceCis) {
		this.tblResourceCis = tblResourceCis;
	}

	public TblResource_CI addTblResourceCi(TblResource_CI tblResourceCi) {
		getTblResourceCis().add(tblResourceCi);
		tblResourceCi.setTblResource(this);

		return tblResourceCi;
	}

	public TblResource_CI removeTblResourceCi(TblResource_CI tblResourceCi) {
		getTblResourceCis().remove(tblResourceCi);
		tblResourceCi.setTblResource(null);

		return tblResourceCi;
	}

}