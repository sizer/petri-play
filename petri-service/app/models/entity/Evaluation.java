package models.entity;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

/**
 * Evaluation entity managed by Ebean
 */
@Entity
public class Evaluation extends AbstractTrailModel {

    /**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

    @Required
    public Integer is_good;

}
