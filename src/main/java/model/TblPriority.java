package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblPriority database table.
 * 
 */
@Entity
@NamedQuery(name="TblPriority.findAll", query="SELECT t FROM TblPriority t")
public class TblPriority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="priority_number")
	private byte priorityNumber;

	private double cost;

	private byte isActive;

	@Column(name="priority_name")
	private String priorityName;

	//bi-directional many-to-one association to TblService
	@OneToMany(mappedBy="tblPriority")
	private List<TblService> tblServices;

	public TblPriority() {
	}

	public byte getPriorityNumber() {
		return this.priorityNumber;
	}

	public void setPriorityNumber(byte priorityNumber) {
		this.priorityNumber = priorityNumber;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getPriorityName() {
		return this.priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public List<TblService> getTblServices() {
		return this.tblServices;
	}

	public void setTblServices(List<TblService> tblServices) {
		this.tblServices = tblServices;
	}

	public TblService addTblService(TblService tblService) {
		getTblServices().add(tblService);
		tblService.setTblPriority(this);

		return tblService;
	}

	public TblService removeTblService(TblService tblService) {
		getTblServices().remove(tblService);
		tblService.setTblPriority(null);

		return tblService;
	}

}