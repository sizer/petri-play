package models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import models.QandaForm;
import play.data.validation.Constraints;
import utils.ModelUtil;

/**
 * Qanda entity managed by Ebean
 */
@Entity
public class Qanda extends AbstractTrailModel {

	/**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

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
    public static Finder<Long,Qanda> find = ModelUtil.getFinder(Qanda.class);

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
