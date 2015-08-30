package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

/**
 * Faq entity managed by Ebean
 */
@Entity
public class Faq extends Model {

    private static final long serialVersionUID = 1L;

	  @Id
    public Long id;

    @Constraints.Required
    public String title;

    @Constraints.Required
    public String question;

    public String answer;

    @ManyToMany
    public List<Tag> tags = new ArrayList<Tag>();

    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date added_date;

    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date updated_date;

    /**
     * Generic query helper for entity Faq with id Long
     */
    public static Finder<Long,Faq> find = new Finder<Long,Faq>(Long.class, Faq.class);

}
