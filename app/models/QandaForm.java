package models;

import models.entity.Qanda;
import play.data.validation.*;
import utils.Boolean;

public class QandaForm{
  @Constraints.Required
  public String title;
  @Constraints.Required
  public String content;
  public String inputTags;
  public boolean isQuestion;

  public QandaForm(){

  }

  public QandaForm(boolean isQuestion){
    this.isQuestion = isQuestion;
  }

  public QandaForm(Qanda q){
    this.title = q.title;
    this.content = q.content;
    this.isQuestion = Boolean.toBool(q.isQuestion);
  }
}
