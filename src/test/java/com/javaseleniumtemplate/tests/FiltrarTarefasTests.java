package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.TarefasDBSteps;
import com.javaseleniumtemplate.dbsteps.ProjetosDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.VisualizarTarefasPage;
import com.javaseleniumtemplate.types.Arquivos;
import com.javaseleniumtemplate.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class FiltrarTarefasTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    VisualizarTarefasPage visualizarTarefasPage;

    //Tests
    @Test
    public void verTarefasMonitoradasComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        visualizarTarefasPage = new VisualizarTarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefa(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        TarefasDBSteps.inserirMonitoramentoTarefa(idIssue);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmVerTarefas();

        visualizarTarefasPage.clicarEmMonitoradoPor();
        visualizarTarefasPage.selecionarTipoMonitoramento(GlobalStaticParameters.MONITORAMENTO_01);
        visualizarTarefasPage.clicarEmAplicarFiltro();

        String tarefa = visualizarTarefasPage.verificarSeExisteTarefaMonitorada(idIssue).replaceFirst("^0+(?!$)", "");

        visualizarTarefasPage.clicarEmRedefinirFiltro();

        Assert.assertEquals(idIssue, tarefa.replaceFirst("^0+(?!$)", ""));


        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarMonitoramentoTarefa(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void verTarefasResolvidasComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        visualizarTarefasPage = new VisualizarTarefasPage();

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

        mainPage.clicarEmVerTarefas();

        visualizarTarefasPage.clicarEmRelacionados();
        visualizarTarefasPage.selecionarRelacionados(GlobalStaticParameters.MONITORAMENTO_01);
        visualizarTarefasPage.clicarEmAplicarFiltro();

        String tarefa = visualizarTarefasPage.verificarSeExisteTarefaResolvida(idIssue).replaceFirst("^0+(?!$)", "");

        visualizarTarefasPage.clicarEmRedefinirFiltro();

        Assert.assertEquals(idIssue, tarefa.replaceFirst("^0+(?!$)", ""));


        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);


    }

    @Test
    public void verTarefasUrgenteComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        visualizarTarefasPage = new VisualizarTarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefaUrgente(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmVerTarefas();

        visualizarTarefasPage.clicarEmPrioridade();
        visualizarTarefasPage.selecionarPrioridade(GlobalStaticParameters.FILTRO_URGENTE);
        visualizarTarefasPage.clicarEmAplicarFiltro();

        String tarefa = visualizarTarefasPage.retornaSeTarefaExiste(idIssue).replaceFirst("^0+(?!$)", "");

        visualizarTarefasPage.clicarEmRedefinirFiltro();

        Assert.assertEquals(idIssue, tarefa.replaceFirst("^0+(?!$)", ""));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void fecharUmaTarefaComSucesso() throws FileNotFoundException, InterruptedException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        visualizarTarefasPage = new VisualizarTarefasPage();

        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefa(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmProjetos();
        mainPage.selecionarProjeto();
        mainPage.clicarEmVerTarefas();

        visualizarTarefasPage.selecionarUmaTarefa();
        visualizarTarefasPage.clicarEmSelecionarUmaAcao(GlobalStaticParameters.ACAO);
        visualizarTarefasPage.clicarEmOK();
        visualizarTarefasPage.clicarEmFecharTarefa();
        visualizarTarefasPage.clicarEmEstado();
        visualizarTarefasPage.selecionarEstado(GlobalStaticParameters.STATUS_FECHADO);
        visualizarTarefasPage.clicarEmAplicarFiltro();

        String tarefa = visualizarTarefasPage.retornaSeTarefaExiste(idIssue).replaceFirst("^0+(?!$)", "");

        visualizarTarefasPage.clicarEmRedefinirFiltro();

        Assert.assertEquals(idIssue, tarefa.replaceFirst("^0+(?!$)", ""));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarMonitoramentoTarefa(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void editarTarefaComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        visualizarTarefasPage = new VisualizarTarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefa(idProjeto, idTexto);
        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        String descricaoModificada = FakerUtils.gerarDescricaoTextoAlterado();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();

        visualizarTarefasPage.editarProjeto("000" + idIssue);

        visualizarTarefasPage.adicionarNovaDescricao(descricaoModificada);
        visualizarTarefasPage.clicarEmAtualizar();

        Assert.assertEquals(descricaoModificada, visualizarTarefasPage.validarTextoModificado(descricaoModificada));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }


}
