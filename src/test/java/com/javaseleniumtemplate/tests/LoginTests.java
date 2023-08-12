package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.UsuariosDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.types.Arquivos;
import com.javaseleniumtemplate.utils.ExecutarJavaScriptNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;
    MainPage mainPage;
    LoginFlows loginFlows;

    //Tests
    @Test
    public void efetuarLoginComSucesso() throws FileNotFoundException {

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        UsuariosDBSteps.inserirUsuario();
        String usuario = UsuariosDBSteps.retornarPrimeiroNomeUsuario();

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.clicarEmLogin();

        DadosUsuario usersDados = Arquivos.getJsonUsers();

        loginPage.preencherSenha(usersDados.getPassword());
        loginPage.clicarEmLogin();

        Assert.assertEquals(usuario, mainPage.retornaUsernameDasInformacoesDeLogin());

        UsuariosDBSteps.deletarUsuario(usuario);

    }

    @Test
    public void efetuarLoginComEmailErrado() throws FileNotFoundException {

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        String usuario = GlobalStaticParameters.USER;

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.clicarEmLogin();
        DadosUsuario usersDados = Arquivos.getJsonUsers();
        loginPage.preencherSenha(usersDados.getPassword());
        loginPage.clicarEmLogin();

        Assert.assertEquals(GlobalStaticParameters.EMAIL_ERRO_MSG, mainPage.retornaMensagemErro());

    }

    @Test
    public void efetuarLoginComSenhaErrada() {

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        UsuariosDBSteps.inserirUsuario();
        String usuario = UsuariosDBSteps.retornarPrimeiroNomeUsuario();

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.clicarEmLogin();

        loginPage.preencherSenha(GlobalStaticParameters.SENHA_ERRADA);
        loginPage.clicarEmLogin();

        Assert.assertEquals(GlobalStaticParameters.EMAIL_ERRO_MSG, mainPage.retornaMensagemErro());

        UsuariosDBSteps.deletarUsuario(usuario);


    }

    @Test
    public void efetuarLoginComEmailVazio() {

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        String usuario = "";

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.clicarEmLogin();

        Assert.assertEquals(GlobalStaticParameters.EMAIL_ERRO_MSG, mainPage.retornaMensagemErro());

    }

    @Test
    public void efetuarLoginComSenhaVazia() {

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        UsuariosDBSteps.inserirUsuario();
        String usuario = UsuariosDBSteps.retornarPrimeiroNomeUsuario();
        String senha = "";

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.clicarEmLogin();

        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertEquals(GlobalStaticParameters.EMAIL_ERRO_MSG, mainPage.retornaMensagemErro());

        UsuariosDBSteps.deletarUsuario(usuario);


    }

    @Test
    public void efetuarLoginComCaracterEspecial() {

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        String usuario = GlobalStaticParameters.USER_CARACTER_ESPECIAL;

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.clicarEmLogin();


        Assert.assertEquals(GlobalStaticParameters.EMAIL_ERRO_MSG, mainPage.retornaMensagemErro());

    }

    @Test
    public void efetuarLoginComUsuarioVazioJavaScript() {

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        String usuario = "";

        //Test
        loginPage.preencherUsuario(usuario);
        loginPage.clicarEmLogin();

        Assert.assertTrue(ExecutarJavaScriptNode.validaJavaScript(GlobalStaticParameters.EMAIL_ERRO_MSG, mainPage.retornaMensagemErro()));

    }

    @Test
    public void fazerLogout() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        loginPage = new LoginPage();

        //Parameters
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmAdministrador();
        mainPage.clicarEmSair();

        Assert.assertTrue(loginPage.retornaOCampoUsername());


    }


}
