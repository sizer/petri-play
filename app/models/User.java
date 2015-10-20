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
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "createUser")
		public List<Evaluation> evaluations = new ArrayList<Evaluation>();
		@OneToMany(cascade = CascadeType.ALL, mappedBy ="createUser")
		public List<Qanda> qandas = new ArrayList<Qanda>();
		@ManyToMany
    public List<Roll> rolls = new ArrayList<Roll>();

    /**
     * Generic query helper for entity User with id Long
     */
    public static Finder<Long,User> find = new Finder<Long,User>(Long.class, User.class);

		public static String getUserName(Long id){
			return find.byId(id).name;
		}

		public Integer getQuestionSize(){
			int count = 0;
			for(Qanda q : qandas){
				if(q.isQuestion == 1){
					count++;
				}
			}
			return count;
		}

		public Integer getAnswerSize(){
			int count = 0;
			for(Qanda q : qandas){
				if(q.isQuestion == 0){
					count++;
				}
			}
			return count;
		}

		public static User createTestUser(){
			return find.byId(1L);
		}
}
