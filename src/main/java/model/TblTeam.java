package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblTeam database table.
 * 
 */
@Entity
@NamedQuery(name="TblTeam.findAll", query="SELECT t FROM TblTeam t")
public class TblTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblTeamPK id;

	private byte isActive;

	//bi-directional many-to-one association to TblResolution
	@OneToMany(mappedBy="tblTeam")
	private List<TblResolution> tblResolutions;

	//bi-directional many-to-one association to TblCourse
	@ManyToOne
	@JoinColumn(name="course")
	private TblCourse tblCourse;

	public TblTeam() {
	}

	public TblTeamPK getId() {
		return this.id;
	}

	public void setId(TblTeamPK id) {
		this.id = id;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public List<TblResolution> getTblResolutions() {
		return this.tblResolutions;
	}

	public void setTblResolutions(List<TblResolution> tblResolutions) {
		this.tblResolutions = tblResolutions;
	}

	public TblResolution addTblResolution(TblResolution tblResolution) {
		getTblResolutions().add(tblResolution);
		tblResolution.setTblTeam(this);

		return tblResolution;
	}

	public TblResolution removeTblResolution(TblResolution tblResolution) {
		getTblResolutions().remove(tblResolution);
		tblResolution.setTblTeam(null);

		return tblResolution;
	}

	public TblCourse getTblCourse() {
		return this.tblCourse;
	}

	public void setTblCourse(TblCourse tblCourse) {
		this.tblCourse = tblCourse;
	}

}