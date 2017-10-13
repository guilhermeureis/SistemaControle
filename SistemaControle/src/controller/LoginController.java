package controller;

import model.Login;

public class LoginController
{
  public LoginController() {}
  
  public java.util.ArrayList<Login> buscarLoginSenha() throws java.sql.SQLException
  {
    return dao.LoginDao.buscarLogin();
  }
}