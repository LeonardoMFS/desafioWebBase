package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.UsuariosDBSteps;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.ResetPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecuperarSenhaTests extends TestBase {
    //Objects
    LoginPage loginPage;
    MainPage mainPage;
    ResetPage resetPage;

    //Tests
    @Test
    public void recuperarSenhaComSucesso() {

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        resetPage = new ResetPage();

        //Parameteres
        UsuariosDBSteps.inserirUsuario();
        String usuario = UsuariosDBSteps.retornarPrimeiroNomeUsuario();
        String email = UsuariosDBSteps.retornarEmailUsuario();

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.clicarEmLogin();

        mainPage.clicarEmEsqueceuSenha();
        resetPage.preencherEmailRecuperar(email);
        resetPage.clicarEnviarButton();

        Assert.assertFalse(mainPage.verificarSeExisteOCampoEmail());

        UsuariosDBSteps.deletarUsuario(usuario);

    }


}
