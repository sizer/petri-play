package controllers;

import java.util.*;
import play.*;
import play.mvc.*;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.RequireCSRFCheck;
import play.mvc.Security.Authenticated;
import play.data.*;
import models.QandaForm;
import models.service.dao.QandaDao;
import models.service.qanda.QandaService;
import models.entity.Qanda;
import models.entity.User;
import views.html.qanda.*;
import models.service.cmn.PetriAuthenticator;

@Authenticated(PetriAuthenticator.class)
public class QandaController extends Controller{
  static QandaDao dao = QandaDao.use();

  public static Result index(){
    List<Qanda> questionList = QandaService.getQuestions();
    return ok(index.render(questionList));
  }

  @AddCSRFToken
  public static Result create(){
    Form<QandaForm> form = new Form(QandaForm.class);
    return ok(create.render(form, null));
  }

  @RequireCSRFCheck
  public static Result insert(){
    Form<QandaForm> form = new Form(QandaForm.class).bindFromRequest();

    if(form.hasErrors()){
      return ok(create.render(form, null));
    }else{
      QandaForm input = form.get();
      Qanda entity = new Qanda(input);
      QandaService.insertQanda(entity);
      return ok(qanda.render(dao.findById(entity.id).get(), new ArrayList<String>()));
    }
  }

  public static Result show(Long id){
    Qanda entity = dao.findById(id).get();
    return ok(qanda.render(entity, new ArrayList<String>()));
  }

  @AddCSRFToken
  public static Result edit(Long id){
    Form<QandaForm> form = new Form(QandaForm.class);
    Qanda qandaEntity = dao.findById(id).get();

    if(qandaEntity.createUser.id != User.getLoginUser().id){
      List<String> errMsgList = new ArrayList<>();
      errMsgList.add("自分の投稿以外は編集できません。");
      return ok(qanda.render(qandaEntity, errMsgList));
    }

    QandaForm faqEntity = new QandaForm(qandaEntity);
    form = form.fill(faqEntity);
    return ok(create.render(form, id));
  }

  @RequireCSRFCheck
  public static Result update(Long id){
    Form<QandaForm> form = new Form(QandaForm.class).bindFromRequest();

    if(form.hasErrors()){
      return ok(create.render(form, id));
    }else{
      QandaForm faqEntity = form.get();
      Qanda entity = dao.findById(id).get();
      entity.setForm(faqEntity.title, faqEntity.content);
      entity.save();
      return ok(qanda.render(dao.findById(entity.id).get(), new ArrayList<String>()));
    }
  }

  public static Result delete(Long id){
    Qanda q = dao.findById(id).get();
    if(q.createUser.id != User.getLoginUser().id){
      List<String> errMsgList = new ArrayList<>();
      errMsgList.add("自分の投稿以外は削除できません。");
      return ok(qanda.render(q, errMsgList));
    }
    q.delete();
    List<Qanda> questionList = QandaService.getQuestions();
    return ok(index.render(questionList));
  }

  public static Result search(String keyword){
    return null;
  }
}
