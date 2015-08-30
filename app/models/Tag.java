package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.validation.*;
import com.avaje.ebean.*;

/**
 * Tag entity managed by Ebean
 */
@Entity
public class Tag extends Model {

    private static final long serialVersionUID = 1L;

	  @Id
    public Long id;

    @Constraints.Required
    public String name;

    /**
     * Generic query helper for entity Tag with id Long
     */
    public static Finder<Long,Tag> find = new Finder<Long,Tag>(Long.class, Tag.class);

}
