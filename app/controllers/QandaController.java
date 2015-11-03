package controllers;

import java.util.ArrayList;
import java.util.List;

import models.QandaForm;
import models.entity.Qanda;
import models.entity.User;
import models.service.cmn.PetriAuthenticator;
import models.service.dao.QandaDao;
import play.data.Form;
import play.db.jpa.Transactional;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.RequireCSRFCheck;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.qanda.create;
import views.html.qanda.index;
import views.html.qanda.qanda;

@Authenticated(PetriAuthenticator.class)
public class QandaController extends Controller {

	public static QandaDao dao = new QandaDao();

	@Transactional
	public static Result index() {
		List<Qanda> questionList = dao.getQuestions();
		return ok(index.render(questionList));
	}

	@AddCSRFToken
	public static Result create() {
		Form<QandaForm> form = new Form(QandaForm.class);
		return ok(create.render(form, null));
	}

	@RequireCSRFCheck
	@Transactional
	public static Result insert() {
		System.out.println("insert()");
		Form<QandaForm> form = new Form(QandaForm.class).bindFromRequest();

		if (form.hasErrors()) {
			return ok(create.render(form, null));
		} else {
			QandaForm input = form.get();
			Qanda entity = new Qanda(input);
			entity.setIsQuestion(1);
			dao.insert(entity);
			return ok(qanda.render(dao.findByPK(Qanda.class, entity.id), new ArrayList<String>()));
		}
	}

	@Transactional
	public static Result show(Long id) {
		Qanda entity = dao.findByPK(Qanda.class, id);
		return ok(qanda.render(entity, new ArrayList<String>()));
	}

	@AddCSRFToken
	@Transactional
	public static Result edit(Long id) {
		Form<QandaForm> form = new Form(QandaForm.class);
		Qanda qandaEntity = dao.findByPK(Qanda.class, id);

//		if (qandaEntity.getCreateUser().getId() != User.getLoginUser().id) {
		if(false){
			List<String> errMsgList = new ArrayList<>();
			errMsgList.add("自分の投稿以外は編集できません。");
			return ok(qanda.render(qandaEntity, errMsgList));
		}

		QandaForm faqEntity = new QandaForm(qandaEntity);
		form = form.fill(faqEntity);
		return ok(create.render(form, id));
	}

	@RequireCSRFCheck
	@Transactional
	public static Result update(Long id) {
		Form<QandaForm> form = new Form(QandaForm.class).bindFromRequest();

		if (form.hasErrors()) {
			return ok(create.render(form, id));
		} else {
			QandaForm faqEntity = form.get();
			Qanda entity = dao.findByPK(Qanda.class, id);
			entity.setForm(faqEntity);
			dao.update(entity);
			return ok(qanda.render(dao.findByPK(Qanda.class, entity.id), new ArrayList<String>()));
		}
	}

	@Transactional
	public static Result delete(Long id) {
		Qanda q = dao.findByPK(Qanda.class, id);
//		if (q.getCreateUser().getId() != User.getLoginUser().id) {
		if(false){
			List<String> errMsgList = new ArrayList<>();
			errMsgList.add("自分の投稿以外は削除できません。");
			return ok(qanda.render(q, errMsgList));
		}
		dao.delete(q);
		List<Qanda> questionList = dao.getQuestions();
		return ok(index.render(questionList));
	}

	public static Result search(String keyword) {
		return null;
	}
}
