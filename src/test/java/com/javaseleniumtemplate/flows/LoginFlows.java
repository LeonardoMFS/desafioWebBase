package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LoginPage;

public class LoginFlows {
    LoginPage loginPage;

    public LoginFlows(){
        loginPage = new LoginPage();
    }

    //Flows
    public void efetuarLogin(String username, String password){
        loginPage.preencherUsuario(username);
        loginPage.clicarEmLogin();
        loginPage.preencherSenha(password);
        loginPage.clicarEmLogin();
    }
}
