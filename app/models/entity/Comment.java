package models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import utils.ModelUtil;

/**
 * Comment entity managed by Ebean
 */
@Entity
public class Comment extends AbstractTrailModel {

    /**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
    public Long id;
    @Constraints.Required
    public String comment;

    /**
     * Generic query helper for entity Comment with id Long
     */
    public static Finder<Long,Comment> find = ModelUtil.getFinder(Comment.class);

}
