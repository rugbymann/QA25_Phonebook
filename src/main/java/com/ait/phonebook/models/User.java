package com.ait.phonebook.models;

public class User {
 private    String email;
  private   String password ;

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPassword() {
        return password;
    }

}