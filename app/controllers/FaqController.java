package controllers;

import java.util.*;
import play.*;
import play.mvc.*;
import play.data.*;
import models.Faq;
import views.html.faq.*;

public class FaqController extends Controller{
  public static Result index(){
    List<Faq> faqList = Faq.find.all();
    return ok(index.render(faqList));
  }

  public static Result create(){
    Form<Faq> faqForm = new Form(Faq.class);
    return ok(create.render(faqForm, null));
  }

  public static Result insert(){
    Form<Faq> f = new Form(Faq.class).bindFromRequest();
    Faq faqEntity = f.get();

    if(f.hasErrors()){
      return ok(create.render(f, null));
    }else{
      faqEntity.create_time = new Date();
      faqEntity.save();
      return ok(faq.render(Faq.find.byId(faqEntity.id)));
    }
  }

  public static Result show(Long id){
    Faq faqEntity = Faq.find.byId(id);
    return ok(faq.render(faqEntity));
  }

  public static Result update(Long id){
    Form<Faq> faqForm = new Form(Faq.class);
    Faq faqEntity = Faq.find.byId(id);
    faqForm.fill(faqEntity);
    return ok(create.render(faqForm, faqEntity.id));
  }

  public static Result doUpdate(){
    Form<Faq> f = new Form(Faq.class).bindFromRequest();
    Faq faqEntity = f.get();

    if(f.hasErrors()){
      return ok(create.render(f, faqEntity.id));
    }else{
      faqEntity.update_time = new Date();
      faqEntity.save();
      return ok(faq.render(Faq.find.byId(faqEntity.id)));
    }
  }

  public static Result delete(Long id){
    return null;
  }
}
