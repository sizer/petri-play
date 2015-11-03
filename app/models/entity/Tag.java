package models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import utils.ModelUtil;

/**
 * Tag entity managed by Ebean
 */
@Entity
public class Tag extends AbstractTrailModel {

    /**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

	  @Id
    public Long id;
    @Required
    public String name;

    /**
     * Generic query helper for entity Tag with id Long
     */
    public static Finder<Long,Tag> find = ModelUtil.getFinder(Tag.class);

}