package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ResetPage extends PageBase {
    By emailResetField = By.xpath("//input[@id='email-field']");
    By enviarButton = By.xpath("//input[@type='submit']");

    public void preencherEmailRecuperar(String email) {
        sendKeys(emailResetField, email);
    }

    public void clicarEnviarButton() {
        click(enviarButton);
    }

}
