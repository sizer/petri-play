package models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;

/**
 * Roll entity managed by Ebean
 */
@Entity
public class Roll extends AbstractTrailModel {

    /**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

	  @Id
    public Long id;
		@Constraints.Required
		public String name;

    /**
     * Generic query helper for entity Roll with id Long
     */
    public static Finder<Long,Roll> find = new Finder<Long,Roll>(Long.class, Roll.class);

}
