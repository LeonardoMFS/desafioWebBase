package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.TarefasDBSteps;
import com.javaseleniumtemplate.dbsteps.MarcadorDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.GerenciarMarcadorPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.types.Arquivos;
import com.javaseleniumtemplate.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class GerenciarMarcadoresTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    GerenciarMarcadorPage gerenciarMarcadorPage;

    //Tests
    @Test
    public void criarMarcadorComSucesso() throws FileNotFoundException {

        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarMarcadorPage = new GerenciarMarcadorPage();

        //Parameters
        String nomeMarcador = FakerUtils.gerarNomeMarcadorAleatorio();
        String descricao = FakerUtils.gerarDescricaoAleatoria();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarMarcadorPage.clicarEmGerenciarMarcador();
        gerenciarMarcadorPage.preencherNomeMarcador(nomeMarcador);

        gerenciarMarcadorPage.preencherDescricao(descricao);
        gerenciarMarcadorPage.clicarEmCriarMarcador();

        Assert.assertEquals(nomeMarcador, MarcadorDBSteps.retornaNomeMarcador());

        MarcadorDBSteps.deletarMarcador(nomeMarcador);
        TarefasDBSteps.deletarBugTextoTarefa();

    }

    @Test
    public void deletarMarcadorComSucesso() throws FileNotFoundException {

        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarMarcadorPage = new GerenciarMarcadorPage();

        //Paremeters
        MarcadorDBSteps.inserirMarcador();
        String nomeMarcador = MarcadorDBSteps.retornaNomeMarcador();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarMarcadorPage.clicarEmGerenciarMarcador();
        gerenciarMarcadorPage.selecionarMarcador(nomeMarcador);
        gerenciarMarcadorPage.clicarEmApagarMarcador();
        gerenciarMarcadorPage.clicarEmApagarMarcador();

        Assert.assertFalse(gerenciarMarcadorPage.retornaMarcador(nomeMarcador));

    }

    @Test
    public void criarMarcadorSemNomeObrigatorio() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarMarcadorPage = new GerenciarMarcadorPage();

        //Parameters
        String nomeMarcador = FakerUtils.gerarNomeMarcadorAleatorio();
        DadosUsuario usersDados = Arquivos.getJsonUsers();
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        //Test
        mainPage.clicarEmGerenciar();
        gerenciarMarcadorPage.clicarEmGerenciarMarcador();
        gerenciarMarcadorPage.clicarEmCriarMarcador();

        Assert.assertFalse(gerenciarMarcadorPage.retornaMarcador(nomeMarcador));

    }

}
