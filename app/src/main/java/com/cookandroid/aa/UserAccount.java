package com.cookandroid.aa;

public class UserAccount {

    private String emailId;
    private String password;
    public String idToken; //고유 토큰정보

    public UserAccount(){}



    public String getEmailId(){return emailId;}
    public void setEmailId(String emailId){this.emailId = emailId;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}


    public String getIdToken(){return idToken;}
    public void setidToken(String idToken){this.idToken = idToken;}
}
