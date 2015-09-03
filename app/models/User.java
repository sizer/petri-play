package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

/**
 * User entity managed by Ebean
 */
@Entity
public class User extends AbstractTrailModel {

	  @Id
    public Long id;
		@Constraints.Required
		public String name;
		@Constraints.Required
		public String password;
		@Constraints.Required
		public Integer is_active;

    /**
     * Generic query helper for entity User with id Long
     */
    public static Finder<Long,User> find = new Finder<Long,User>(Long.class, User.class);

}
