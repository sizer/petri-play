package controllers;

import java.util.*;
import play.*;
import play.mvc.*;
import play.data.*;
import models.Qanda;
import views.html.faq.*;

public class QandaController extends Controller{
  public static Result index(){
    List<Qanda> faqList = Qanda.find.all();
    return ok(index.render(faqList));
  }

  public static Result create(){
    Form<Qanda> faqForm = new Form(Qanda.class);
    return ok(create.render(faqForm, null));
  }

  public static Result insert(){
    Form<Qanda> f = new Form(Qanda.class).bindFromRequest();
    Qanda faqEntity = f.get();

    if(f.hasErrors()){
      return ok(create.render(f, null));
    }else{
      faqEntity.create_time = new Date();
      faqEntity.save();
      return ok(faq.render(Qanda.find.byId(faqEntity.id)));
    }
  }

  public static Result show(Long id){
    Qanda faqEntity = Qanda.find.byId(id);
    return ok(faq.render(faqEntity));
  }

  public static Result update(Long id){
    Form<Qanda> faqForm = new Form(Qanda.class);
    Qanda faqEntity = Qanda.find.byId(id);
    faqForm.fill(faqEntity);
    return ok(create.render(faqForm, faqEntity.id));
  }

  public static Result doUpdate(){
    Form<Qanda> f = new Form(Qanda.class).bindFromRequest();
    Qanda faqEntity = f.get();

    if(f.hasErrors()){
      return ok(create.render(f, faqEntity.id));
    }else{
      faqEntity.update_time = new Date();
      faqEntity.save();
      return ok(faq.render(Qanda.find.byId(faqEntity.id)));
    }
  }

  public static Result delete(Long id){
    return null;
  }
}
