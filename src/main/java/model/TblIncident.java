package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the tblIncident database table.
 * 
 */
@Entity
@NamedQuery(name="TblIncident.findAll", query="SELECT t FROM TblIncident t")
public class TblIncident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte incident_ID;

	private byte isActive;

	@Column(name="priority_")
	private byte priority;

	@Column(name="time_")
	private Time time;

	//bi-directional many-to-one association to TblAffected_Service
	@OneToMany(mappedBy="tblIncident")
	private List<TblAffected_Service> tblAffectedServices;

	//bi-directional many-to-one association to TblService
	@ManyToOne
	@JoinColumn(name="root_service_ID")
	private TblService tblService;

	//bi-directional many-to-one association to TblResolution
	@OneToMany(mappedBy="tblIncident")
	private List<TblResolution> tblResolutions;

	public TblIncident() {
	}

	public byte getIncident_ID() {
		return this.incident_ID;
	}

	public void setIncident_ID(byte incident_ID) {
		this.incident_ID = incident_ID;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getPriority() {
		return this.priority;
	}

	public void setPriority(byte priority) {
		this.priority = priority;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<TblAffected_Service> getTblAffectedServices() {
		return this.tblAffectedServices;
	}

	public void setTblAffectedServices(List<TblAffected_Service> tblAffectedServices) {
		this.tblAffectedServices = tblAffectedServices;
	}

	public TblAffected_Service addTblAffectedService(TblAffected_Service tblAffectedService) {
		getTblAffectedServices().add(tblAffectedService);
		tblAffectedService.setTblIncident(this);

		return tblAffectedService;
	}

	public TblAffected_Service removeTblAffectedService(TblAffected_Service tblAffectedService) {
		getTblAffectedServices().remove(tblAffectedService);
		tblAffectedService.setTblIncident(null);

		return tblAffectedService;
	}

	public TblService getTblService() {
		return this.tblService;
	}

	public void setTblService(TblService tblService) {
		this.tblService = tblService;
	}

	public List<TblResolution> getTblResolutions() {
		return this.tblResolutions;
	}

	public void setTblResolutions(List<TblResolution> tblResolutions) {
		this.tblResolutions = tblResolutions;
	}

	public TblResolution addTblResolution(TblResolution tblResolution) {
		getTblResolutions().add(tblResolution);
		tblResolution.setTblIncident(this);

		return tblResolution;
	}

	public TblResolution removeTblResolution(TblResolution tblResolution) {
		getTblResolutions().remove(tblResolution);
		tblResolution.setTblIncident(null);

		return tblResolution;
	}

}