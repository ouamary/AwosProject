package fr.dauphine.spring.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.Parameter;

@Component
@Entity @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@SQLDelete(sql="update BO set deleted = 1 where id = ? and version = ?")
@Where(clause="deleted <> 1")
abstract public class BO {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid", parameters = {@Parameter(name="unsaved-value" , value="undefined")})
	protected String id;
	
	@Version
	private Long version;
	
	private boolean deleted;
	
	

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}