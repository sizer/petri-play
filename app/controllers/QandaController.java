package controllers;

import java.util.*;
import play.*;
import play.mvc.*;
import play.data.*;
import models.Qanda;
import models.QandaForm;
import views.html.qanda.*;

public class QandaController extends Controller{
  public static Result index(){
    List<Qanda> faqList = Qanda.getQuestions();
    return ok(index.render(faqList));
  }

  public static Result create(){
    Form<QandaForm> f = new Form(QandaForm.class);
    return ok(create.render(f, null));
  }

  public static Result insert(){
    Form<QandaForm> f = new Form(QandaForm.class).bindFromRequest();

    if(f.hasErrors()){
      return ok(create.render(f, null));
    }else{
      QandaForm faqEntity = f.get();
      Qanda qandaEntity = new Qanda(faqEntity);
      qandaEntity.setTrailInfo(Qanda.INSERT);
      qandaEntity.isQuestion = 1;
      qandaEntity.save();
      return ok(qanda.render(Qanda.find.byId(qandaEntity.id)));
    }
  }

  public static Result show(Long id){
    Qanda faqEntity = Qanda.find.byId(id);
    return ok(qanda.render(faqEntity));
  }

  public static Result edit(Long id){
    Form<QandaForm> faqForm = new Form(QandaForm.class);
    QandaForm faqEntity = new QandaForm(Qanda.find.byId(id));
    faqForm = faqForm.fill(faqEntity);
    return ok(create.render(faqForm, id));
  }

  public static Result update(Long id){
    Form<QandaForm> f = new Form(QandaForm.class).bindFromRequest();

    if(f.hasErrors()){
      System.out.println("hasError");
      System.out.println(f);      
      return ok(create.render(f, id));
    }else{
      QandaForm faqEntity = f.get();
      Qanda qandaEntity = Qanda.find.byId(id);
      qandaEntity.setForm(faqEntity);
      qandaEntity.setTrailInfo(Qanda.UPDATE);
      qandaEntity.save();
      return ok(qanda.render(Qanda.find.byId(qandaEntity.id)));
    }
  }

  public static Result delete(Long id){
    return null;
  }

  public static Result search(String keyword){
    return null;
  }
}
