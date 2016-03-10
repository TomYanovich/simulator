package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tblTeam database table.
 * 
 */
@Embeddable
public class TblTeamPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String course;

	@Column(name="team_name")
	private String teamName;

	public TblTeamPK() {
	}
	public String getCourse() {
		return this.course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getTeamName() {
		return this.teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblTeamPK)) {
			return false;
		}
		TblTeamPK castOther = (TblTeamPK)other;
		return 
			this.course.equals(castOther.course)
			&& this.teamName.equals(castOther.teamName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.course.hashCode();
		hash = hash * prime + this.teamName.hashCode();
		
		return hash;
	}
}