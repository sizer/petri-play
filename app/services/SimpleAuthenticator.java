package services;

import utils.Charactor;

public class SimpleAuthenticator{

  public boolean authenticate(String id, String pass){
    return !Charactor.isBlank(id);
  }

}
