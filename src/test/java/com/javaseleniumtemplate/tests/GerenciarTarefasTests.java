package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.TarefasDBSteps;
import com.javaseleniumtemplate.dbsteps.ProjetosDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.TarefasPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.types.Arquivos;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class GerenciarTarefasTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    TarefasPage tarefasPage;

    //Tests
    @Test
    public void visualizarTarefaAtribuidaAMimComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        tarefasPage = new TarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefaHandlerId(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.clicarVerTarefasAtribuidasAMimNaoResolvida();

        Assert.assertTrue(tarefasPage.retornaTarefaAtribuida(idIssue));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void visualizarTarefaNaoAtribuidasAMimComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        tarefasPage = new TarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefa(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.clicarVerTarefasNaoAtribuidasAMim();

        Assert.assertTrue(tarefasPage.retornaTarefaAtribuida(idIssue));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void visualizarTarefasRelatadasPorMimComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        tarefasPage = new TarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefa(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.clicarVerTarefasRelatadasPorMim();

        Assert.assertTrue(tarefasPage.retornaTarefaAtribuida(idIssue));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void visualizarTarefasResolvidasComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        tarefasPage = new TarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefaResolvida(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.clicarVerTarefasResolvidas();

        Assert.assertTrue(tarefasPage.retornaTarefaAtribuida(idIssue));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }


    @Test
    public void visualizarTarefasMonitoradasComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        tarefasPage = new TarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefaResolvida(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        TarefasDBSteps.inserirMonitoramentoTarefa(idIssue);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.clicarVerTarefasMonitoradas();

        Assert.assertTrue(tarefasPage.retornaTarefaAtribuida(idIssue));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarMonitoramentoTarefa(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void visualizarTarefasModificadasComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        tarefasPage = new TarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefaHandlerId(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.clicarVerTarefasModificadas();

        Assert.assertTrue(tarefasPage.retornaTarefaAtribuida(idIssue));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }



}
