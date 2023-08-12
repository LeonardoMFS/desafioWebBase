package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//input[@type='submit']");


    //Actions
    public void preencherUsuario(String usuario) {
        sendKeys(usernameField, usuario);
    }

    public void preencherSenha(String senha) {
        sendKeys(passwordField, senha);
    }

    public void clicarEmLogin() {
        click(loginButton);
    }
    public boolean retornaOCampoUsername() {
        return returnIfElementIsDisplayed(usernameField);
    }

}
