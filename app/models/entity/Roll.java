package models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints;

/**
 * Roll entity managed by Ebean
 */
@Entity
public class Roll extends AbstractTrailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	@Constraints.Required
	public String name;
}
