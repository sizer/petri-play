package models;

import play.data.validation.Constraints;
import models.entity.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
  @Constraints.Required
  private String name;
  @Constraints.Required
  private String password;

  public String validate(){
    if (authenticate(name, password) == null){
      return "Invalid user or password";
    }
    return null;
  }

  public static User authenticate(String name, String password){
    String hashedPassword = "";
    if (password != null){
      try{
        hashedPassword = sha512(password);
      } catch(NoSuchAlgorithmException e){
        throw new RuntimeException();
      }
    }
    return User.find.where()
      .eq("name", name)
      .eq("password", hashedPassword)
      .findUnique();
  }

  public static String sha512(String message) throws NoSuchAlgorithmException{
    MessageDigest md = MessageDigest.getInstance("SHA-512");
    StringBuilder sb = new StringBuilder();
    md.update(message.getBytes());
    byte[] mb = md.digest();
    for (byte m : mb){
      String hex = String.format("%02x", m);
      sb.append(hex);
    }
    return sb.toString();
  }
}
