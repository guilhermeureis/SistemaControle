package controller;

import dao.LoginDao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Login;

public class LoginController {
    public ArrayList<Login> buscarLoginSenha() throws SQLException{
        return LoginDao.buscarLogin();
    }
}
