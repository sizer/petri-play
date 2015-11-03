package models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints;

/**
 * Tag entity managed by Ebean
 */
@Entity
public class Tag extends AbstractTrailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	@Constraints.Required
	public String name;
}
