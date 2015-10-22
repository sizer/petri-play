package controllers;

import java.util.*;
import play.*;
import play.mvc.*;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.RequireCSRFCheck;
import play.mvc.Security.Authenticated;
import play.data.*;
import models.Qanda;
import models.QandaForm;
import models.User;
import views.html.qanda.*;
import services.PetriAuthenticator;

@Authenticated(PetriAuthenticator.class)
public class QandaController extends Controller{

  public static Result index(){
    List<Qanda> questionList = Qanda.getQuestions();
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
      entity.isQuestion = 1;
      entity.save();
      return ok(qanda.render(Qanda.find.byId(entity.id), new ArrayList<String>()));
    }
  }

  public static Result show(Long id){
    Qanda entity = Qanda.find.byId(id);
    return ok(qanda.render(entity, new ArrayList<String>()));
  }

  @AddCSRFToken
  public static Result edit(Long id){
    Form<QandaForm> form = new Form(QandaForm.class);
    Qanda qandaEntity = Qanda.find.byId(id);

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
      Qanda entity = Qanda.find.byId(id);
      entity.setForm(faqEntity);
      entity.save();
      return ok(qanda.render(Qanda.find.byId(entity.id), new ArrayList<String>()));
    }
  }

  public static Result delete(Long id){
    Qanda q = Qanda.find.byId(id);
    if(q.createUser.id != User.getLoginUser().id){
      List<String> errMsgList = new ArrayList<>();
      errMsgList.add("自分の投稿以外は削除できません。");
      return ok(qanda.render(q, errMsgList));
    }
    q.delete();
    List<Qanda> questionList = Qanda.getQuestions();
    return ok(index.render(questionList));
  }

  public static Result search(String keyword){
    return null;
  }
}
