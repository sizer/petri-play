package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

/**
 * Tag entity managed by Ebean
 */
@Entity
public class Tag extends AbstractTrailModel<Tag> {

	  @Id
    public Long id;
    @Constraints.Required
    public String name;

    /**
     * Generic query helper for entity Tag with id Long
     */
    public static Finder<Long,Tag> find = new Finder<Long,Tag>(Long.class, Tag.class);

}
