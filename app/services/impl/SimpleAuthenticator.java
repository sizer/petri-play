package services.impl;

import utils.Charactor;
import services.Authenticator;

public class SimpleAuthenticator implements Authenticator{

  public boolean authenticate(String id, String pass){
    return !Charactor.isBlank(id);
  }
}
