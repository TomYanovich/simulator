package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the tblResolution database table.
 * 
 */
@Entity
@NamedQuery(name="TblResolution.findAll", query="SELECT t FROM TblResolution t")
public class TblResolution implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblResolutionPK id;

	private byte isPurchased;

	private byte isResolved;

	@Column(name="resolution_time")
	private Time resolutionTime;

	//bi-directional many-to-one association to TblIncident
	@ManyToOne
	@JoinColumn(name="incident_ID")
	private TblIncident tblIncident;

	//bi-directional many-to-one association to TblTeam
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="course", referencedColumnName="course"),
		@JoinColumn(name="team", referencedColumnName="team_name")
		})
	private TblTeam tblTeam;

	public TblResolution() {
	}

	public TblResolutionPK getId() {
		return this.id;
	}

	public void setId(TblResolutionPK id) {
		this.id = id;
	}

	public byte getIsPurchased() {
		return this.isPurchased;
	}

	public void setIsPurchased(byte isPurchased) {
		this.isPurchased = isPurchased;
	}

	public byte getIsResolved() {
		return this.isResolved;
	}

	public void setIsResolved(byte isResolved) {
		this.isResolved = isResolved;
	}

	public Time getResolutionTime() {
		return this.resolutionTime;
	}

	public void setResolutionTime(Time resolutionTime) {
		this.resolutionTime = resolutionTime;
	}

	public TblIncident getTblIncident() {
		return this.tblIncident;
	}

	public void setTblIncident(TblIncident tblIncident) {
		this.tblIncident = tblIncident;
	}

	public TblTeam getTblTeam() {
		return this.tblTeam;
	}

	public void setTblTeam(TblTeam tblTeam) {
		this.tblTeam = tblTeam;
	}

}