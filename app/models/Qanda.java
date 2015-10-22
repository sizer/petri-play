package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import models.QandaForm;

/**
 * Qanda entity managed by Ebean
 */
@Entity
public class Qanda extends AbstractTrailModel {

	  @Id
    public Long id;
    @Constraints.Required
    public String title;
    @Constraints.Required
    public String content;
    @Constraints.Required
    public Integer isQuestion;
		@OneToMany(cascade = CascadeType.ALL)
		public List<Evaluation> evaluations = new ArrayList<Evaluation>();
    @ManyToMany
    public List<Tag> tags = new ArrayList<Tag>();
		@OneToMany(cascade = CascadeType.ALL)
		public List<Comment> comments = new ArrayList<Comment>();
		@OneToMany(cascade = CascadeType.ALL)
		public List<Qanda> qandas = new ArrayList<Qanda>();
		@ManyToOne
		public Qanda qanda;

		public Qanda(){

		}

		public Qanda(QandaForm qf){
			this.title = qf.title;
			this.content = qf.content;
		}

    /**
     * Generic query helper for entity Qanda with id Long
     */
    public static Finder<Long,Qanda> find = new Finder<Long,Qanda>(Long.class, Qanda.class);

		/**
		 * isQuestion=1をキーに、QANDAリストを取得する
		 */
		public static List<Qanda> getQuestions(){
			return find.where().eq("isQuestion", 1).findList();
		}

		/**
		 * フォームの保持する情報をEntityにセットする。
		 * @param form Qandaフォーム
		 */
		public void setForm(QandaForm form){
			this.title = form.title;
			this.content = form.content;
		}
}
