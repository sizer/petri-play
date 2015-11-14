package models.entity;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

/**
 * Comment entity managed by Ebean
 */
@Entity
public class Comment extends AbstractTrailModel {

    /**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

    @Required
    public String comment;

}
