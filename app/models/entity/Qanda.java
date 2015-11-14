package models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import models.QandaForm;
import models.service.dao.QandaDao;
import play.data.validation.Constraints.Required;

/**
 * Qanda entity managed by Ebean
 */
@Entity
public class Qanda extends AbstractTrailModel {

	/**
	 * serial version ID
	 */
	private static final long serialVersionUID = 1L;

    @Required
    public String title;
    @Required
    public String content;
    @Required
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
		 * フォームの保持する情報をEntityにセットする。
		 * @param form Qandaフォーム
		 */
		public void setForm(String title, String content){
			this.title = title;
			this.content = content;
		}
}
