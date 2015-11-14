package models.entity;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

/**
 * Tag entity managed by Ebean
 */
@Entity
public class Tag extends AbstractTrailModel {

    /**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

    @Required
    public String name;

}
