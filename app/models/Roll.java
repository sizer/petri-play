package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

/**
 * Roll entity managed by Ebean
 */
@Entity
public class Roll extends AbstractTrailModel {

	  @Id
    public Long id;
		@Constraints.Required
		public String name;

    /**
     * Generic query helper for entity Roll with id Long
     */
    public static Finder<Long,Roll> find = new Finder<Long,Roll>(Long.class, Roll.class);

}
