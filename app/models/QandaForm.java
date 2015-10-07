package models;

import play.data.validation.*;

public class QandaForm{
  @Constraints.Required
  public String title;
  @Constraints.Required
  public String content;
  public String inputTags;

  public QandaForm(){

  }

  public QandaForm(Qanda q){
    this.title = q.title;
    this.content = q.content;
  }
}
