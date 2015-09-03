package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

/**
 * Comment entity managed by Ebean
 */
@Entity
public class Comment extends AbstractTrailModel {

	  @Id
    public Long id;
    @Constraints.Required
    public String comment;

    /**
     * Generic query helper for entity Comment with id Long
     */
    public static Finder<Long,Comment> find = new Finder<Long,Comment>(Long.class, Comment.class);

}
