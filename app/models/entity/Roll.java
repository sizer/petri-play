package models.entity;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

/**
 * Roll entity managed by Ebean
 */
@Entity
public class Roll extends AbstractTrailModel {

    /**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

		@Required
		public String name;


}
