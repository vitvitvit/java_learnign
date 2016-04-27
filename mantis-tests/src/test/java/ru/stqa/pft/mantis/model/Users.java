package ru.stqa.pft.mantis.model;

public class Users {
  private String username;
  private String password;
  private String email;

  public String getUsername() {
    return username;
  }

  public Users withUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Users withEmail(String email) {
    this.email = email;
    return this;
  }

}
