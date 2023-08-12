package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;

import org.openqa.selenium.By;

public class GerenciarUsuariosPage extends PageBase {
    By gerenciarUsuariosButton = By.xpath("//a[text()='Gerenciar Usuários']");
    By novaContaButton = By.xpath("//a[text()='Criar nova conta']");
    By nomeUsuarioField = By.id("user-username");
    By nomeVerdadeiroField = By.id("user-realname");
    By emailField = By.id("email-field");
    By criarUsuarioButton = By.xpath("//input[@value='Criar Usuário']");
    By mensagemErroText = By.xpath("//p[@class='bold']");

    public void clicarEmGerenciarUsuarios() {
        click(gerenciarUsuariosButton);
    }

    public void clicarEmNovaConta() {
        click(novaContaButton);
    }

    public void preencherUsuario(String usuario) {
        sendKeys(nomeUsuarioField, usuario);
    }

    public void preencherNomeVerdadeiro(String nomeVerdadeiroTexto) {
        sendKeys(nomeVerdadeiroField, nomeVerdadeiroTexto);
    }

    public void preencherEmail(String emailTexto) {
        sendKeys(emailField, emailTexto);
    }

    public void clicarEmCriarUsuario() {
        click(criarUsuarioButton);
    }

    public String retornaMensagemErro() {
        return getText(mensagemErroText);
    }

}
