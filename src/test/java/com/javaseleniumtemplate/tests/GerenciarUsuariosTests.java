package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.UsuariosDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.GerenciarUsuariosPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.types.Arquivos;
import com.javaseleniumtemplate.utils.ExecutarJavaScriptNode;
import com.javaseleniumtemplate.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class GerenciarUsuariosTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    GerenciarUsuariosPage gerenciarUsuariosPage;

    //Tests
    @Test
    public void criarUsuarioComSucesso() throws FileNotFoundException {

        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarUsuariosPage = new GerenciarUsuariosPage();

        String username = FakerUtils.gerarNomeAleatorio();
        String fullName = FakerUtils.gerarNomeCompletoAleatorio();
        String email = FakerUtils.gerarEmailAleatorio();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarUsuariosPage.clicarEmGerenciarUsuarios();
        gerenciarUsuariosPage.clicarEmNovaConta();
        gerenciarUsuariosPage.preencherUsuario(username);
        gerenciarUsuariosPage.preencherNomeVerdadeiro(fullName);
        gerenciarUsuariosPage.preencherEmail(email);
        gerenciarUsuariosPage.clicarEmCriarUsuario();


        Assert.assertEquals(username, UsuariosDBSteps.retornarPrimeiroNomeUsuario());

        UsuariosDBSteps.deletarEmailUsuario(email);
        UsuariosDBSteps.deletarUsuario(username);

    }

    @Test
    public void criarUsuarioComSucessoNodeJS() throws FileNotFoundException {

        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarUsuariosPage = new GerenciarUsuariosPage();

        String username = "USER" + ExecutarJavaScriptNode.gerarNomeAleatorio();
        String fullName = FakerUtils.gerarNomeCompletoAleatorio();
        String email = FakerUtils.gerarEmailAleatorio();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarUsuariosPage.clicarEmGerenciarUsuarios();
        gerenciarUsuariosPage.clicarEmNovaConta();
        gerenciarUsuariosPage.preencherUsuario(username);
        gerenciarUsuariosPage.preencherNomeVerdadeiro(fullName);
        gerenciarUsuariosPage.preencherEmail(email);
        gerenciarUsuariosPage.clicarEmCriarUsuario();


        Assert.assertEquals(username, UsuariosDBSteps.retornarPrimeiroNomeUsuario());

        UsuariosDBSteps.deletarEmailUsuario(email);
        UsuariosDBSteps.deletarUsuario(username);

    }

    @Test
    public void criarUsuarioSemInformarCamposObrigatorios() throws FileNotFoundException {

        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarUsuariosPage = new GerenciarUsuariosPage();

        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();
        gerenciarUsuariosPage.clicarEmGerenciarUsuarios();
        gerenciarUsuariosPage.clicarEmNovaConta();
        gerenciarUsuariosPage.clicarEmCriarUsuario();


        Assert.assertEquals(GlobalStaticParameters.ERRO_URUARIO_MSG, gerenciarUsuariosPage.retornaMensagemErro());


    }




}
