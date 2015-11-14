package models;

import models.entity.Qanda;
import play.data.validation.Constraints.Required;
import utils.BooleanUtil;

public class QandaForm{
  @Required
  public String title;
  @Required
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
    this.isQuestion = BooleanUtil.toBool(q.isQuestion);
  }
}
