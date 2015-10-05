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
    Map<String, String> map = new HashMap<>();
    map.put("is_question", "1");
    f = f.bind(map);
    System.out.println(f);
    return ok(create.render(f, null));
  }

  public static Result insert(){
    Form<QandaForm> f = new Form(QandaForm.class).bindFromRequest();
    System.out.println(f);

    if(f.hasErrors()){
      return ok(create.render(f, null));
    }else{
      QandaForm faqEntity = f.get();
      faqEntity.create_time = new Date();
      faqEntity.save();
      return ok(qanda.render(Qanda.find.byId(faqEntity.id)));
    }
  }

  public static Result show(Long id){
    Qanda faqEntity = Qanda.find.byId(id);
    return ok(qanda.render(faqEntity));
  }

  public static Result edit(Long id){
    Form<QandaForm> faqForm = new Form(QandaForm.class);
    QandaForm faqEntity = new QandaForm(Qanda.find.byId(id));
    faqForm.fill(faqEntity);
    return ok(create.render(faqForm, faqEntity.id));
  }

  public static Result update(Long id){
    Form<QandaForm> f = new Form(QandaForm.class).bindFromRequest();
    QandaForm faqEntity = f.get();

    if(f.hasErrors()){
      return ok(create.render(f, faqEntity.id));
    }else{
      faqEntity.update_time = new Date();
      faqEntity.save();
      return ok(qanda.render(Qanda.find.byId(faqEntity.id)));
    }
  }

  public static Result delete(Long id){
    return null;
  }

  public static Result search(String keyword){
    return null;
  }
}
