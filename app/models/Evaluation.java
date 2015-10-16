package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

/**
 * Evaluation entity managed by Ebean
 */
@Entity
public class Evaluation extends AbstractTrailModel<Evaluation> {

	  @Id
    public Long id;
    @Constraints.Required
    public Integer is_good;

    /**
     * Generic query helper for entity Evaluation with id Long
     */
    public static Finder<Long,Evaluation> find = new Finder<Long,Evaluation>(Long.class, Evaluation.class);

}
