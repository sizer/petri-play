package models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import models.QandaForm;
import play.data.validation.Constraints.Required;

/**
 * Qanda entity managed by Ebean
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Qanda extends AbstractTrailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	@Required
	public String title;
	@Required
	public String content;
	@Required
	@Column(name = "is_question")
	public Integer isQuestion;
	@OneToMany(cascade = CascadeType.ALL)
	public List<Evaluation> evaluations = new ArrayList<Evaluation>();
	@ManyToMany
  @JoinTable(
      name="qanda_tag",
      joinColumns={@JoinColumn(name="qanda_id", referencedColumnName="id")},
      inverseJoinColumns={@JoinColumn(name="tag_id", referencedColumnName="id")})
 	public List<Tag> tags = new ArrayList<Tag>();
	@OneToMany(cascade = CascadeType.ALL)
	public List<Comment> comments = new ArrayList<Comment>();
	@OneToMany(cascade = CascadeType.ALL)
	public List<Qanda> qandas = new ArrayList<Qanda>();
	@ManyToOne
	public Qanda qanda;

	public Qanda() {

	}

	public Qanda(QandaForm qf) {
		this.title = qf.title;
		this.content = qf.content;
	}

	/**
	 * フォームの保持する情報をEntityにセットする。
	 *
	 * @param form
	 *            Qandaフォーム
	 */
	public void setForm(QandaForm form) {
		this.title = form.title;
		this.content = form.content;
	}
}
