package models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import utils.ModelUtil;

/**
 * Evaluation entity managed by Ebean
 */
@Entity
public class Evaluation extends AbstractTrailModel {

    /**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

	  @Id
    public Long id;
    @Constraints.Required
    public Integer is_good;

    /**
     * Generic query helper for entity Evaluation with id Long
     */
    public static Finder<Long,Evaluation> find = ModelUtil.getFinder(Evaluation.class);

}
