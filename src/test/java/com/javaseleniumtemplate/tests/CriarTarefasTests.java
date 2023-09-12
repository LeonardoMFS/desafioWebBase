package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.TarefasDBSteps;
import com.javaseleniumtemplate.dbsteps.ProjetosDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.CriarTarefasPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.VisualizarTarefasPage;
import com.javaseleniumtemplate.types.Arquivos;
import com.javaseleniumtemplate.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class CriarTarefasTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    CriarTarefasPage criarTarefasPage;
    VisualizarTarefasPage visualizarTarefasPage;

    //Tests
    @Test
    public void criarTarefaComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        criarTarefasPage = new CriarTarefasPage();
        visualizarTarefasPage = new VisualizarTarefasPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmCriarTarefas();

        criarTarefasPage.preencherResumoArea(FakerUtils.gerarSumarioIssueAleatoria());
        criarTarefasPage.preencherDescricaoArea(FakerUtils.gerarDescricaoAleatoria());
        criarTarefasPage.clicarEmNovaTarefa();

        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        String issue = visualizarTarefasPage.retornaSeTarefaExiste(idIssue);

        Assert.assertEquals(idIssue, issue.replaceFirst("^0+(?!$)", ""));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTextoTarefa();
        TarefasDBSteps.deletarHistoricoBug(idIssue);

    }

    

}
