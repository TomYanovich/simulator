package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblCI_Department database table.
 * 
 */
@Entity
@NamedQuery(name="TblCI_Department.findAll", query="SELECT t FROM TblCI_Department t")
public class TblCI_Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblCI_DepartmentPK id;

	private byte isActive;

	//bi-directional many-to-one association to TblCI
	@ManyToOne
	@JoinColumn(name="service_ID")
	private TblCI tblCi;

	public TblCI_Department() {
	}

	public TblCI_DepartmentPK getId() {
		return this.id;
	}

	public void setId(TblCI_DepartmentPK id) {
		this.id = id;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public TblCI getTblCi() {
		return this.tblCi;
	}

	public void setTblCi(TblCI tblCi) {
		this.tblCi = tblCi;
	}

}