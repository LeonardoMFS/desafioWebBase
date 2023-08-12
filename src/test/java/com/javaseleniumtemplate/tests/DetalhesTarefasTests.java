package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.ProjetosDBSteps;
import com.javaseleniumtemplate.dbsteps.TarefasDBSteps;
import com.javaseleniumtemplate.dbsteps.UsuariosDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.VisualizarTarefasPage;
import com.javaseleniumtemplate.types.Arquivos;
import com.javaseleniumtemplate.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DetalhesTarefasTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    VisualizarTarefasPage visualizarTarefasPage;

    //Tests
    @Test
    public void visualizarDetalhesTarefaComSucesso() throws FileNotFoundException {

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
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000" + idIssue);

        Assert.assertEquals(idIssue, visualizarTarefasPage.retornaNomeTarefa().replaceFirst("^0+(?!$)", ""));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void copiarTarefasComSucesso() throws FileNotFoundException {

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

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000" + idIssue);

        visualizarTarefasPage.clicarEmCopiarTarefa();
        visualizarTarefasPage.clicarEmCriarNovaTarefaCopiada();

        String idIssueCopiada = TarefasDBSteps.retornaDadosTarefa().get(0);

        Assert.assertEquals(idIssueCopiada, visualizarTarefasPage.retornaNomeTarefa().replaceFirst("^0+(?!$)", ""));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssueCopiada);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssueCopiada);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void atualizarStatusTarefa() throws FileNotFoundException {

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

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000" + idIssue);

        visualizarTarefasPage.clicarEmSelecionarUmStatus(GlobalStaticParameters.STATUS_RESOLVIDO);
        visualizarTarefasPage.clicarEmAlterarStatus();
        visualizarTarefasPage.clicarEmResolverTarefa();

        Assert.assertEquals(visualizarTarefasPage.verificarSeEstaResolvido(), GlobalStaticParameters.RESOLVIDO);

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarMonitoramentoTarefa(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void atribuirUsuarioUmaTarefa() throws FileNotFoundException {

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
        UsuariosDBSteps.inserirUsuario();
        String username = UsuariosDBSteps.retornarPrimeiroNomeUsuario();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000" + idIssue);

        visualizarTarefasPage.clicarEmSelecionarUmUsuarioAtribuido(username);
        visualizarTarefasPage.clicarEmSelecionarUmUsuario();

        Assert.assertEquals(visualizarTarefasPage.verificarSelecionarUmUsuario(username), username);

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        UsuariosDBSteps.deletarUsuario(username);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarMonitoramentoTarefa(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void relacionarStatusUmaTarefa() throws FileNotFoundException {

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
        TarefasDBSteps.inserirTextoTarefa();
        String idTextoIssue2 = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefa(idProjeto, idTextoIssue2);
        ArrayList<String> idsIssues = TarefasDBSteps.retornaDadosTodasIssueIdProjeto(idProjeto);
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000" + idsIssues.get(0));

        visualizarTarefasPage.preencherTarefaRelacionada(idsIssues.get(3));
        visualizarTarefasPage.adicionarRelacao();

        Assert.assertEquals(visualizarTarefasPage.verificarSeExisteTarefaSub(idsIssues.get(3)).replaceFirst("^0+(?!$)", ""), idsIssues.get(3));

        String idIssue = idsIssues.get(0);
        String idIssue1 = idsIssues.get(3);

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarRelacionamento(idsIssues.get(0));
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarTarefaId(idIssue1);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue1);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);
        TarefasDBSteps.deletarTextoIdTarefa(idTextoIssue2);

    }

    @Test
    public void adicionarAnotacaoVerTarefasComSucesso() throws FileNotFoundException {

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
        String anotacaoTexto = FakerUtils.gerarDescricaoAnotacoes();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000" + idIssue);

        visualizarTarefasPage.preencherAnotacoes(anotacaoTexto);
        visualizarTarefasPage.clicarEmAdicionarAnotacao();

        Assert.assertEquals(anotacaoTexto, visualizarTarefasPage.verificarAnotacoes());

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        String idNote = TarefasDBSteps.retornarIdAnotacaoBug();
        String idNoteText = TarefasDBSteps.retornarIdTextoAnotacaoBug();
        TarefasDBSteps.deletarAnotacaoTextoBug(idNoteText);
        TarefasDBSteps.deletarAnotacaoBug(idNote);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);
    }

    @Test
    public void apagarAnotacoesVerTarefasComSucesso() throws FileNotFoundException {

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
        String anotacaoTexto = FakerUtils.gerarDescricaoAnotacoes();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000" + idIssue);

        visualizarTarefasPage.preencherAnotacoes(anotacaoTexto);
        visualizarTarefasPage.clicarEmAdicionarAnotacao();
        visualizarTarefasPage.clicarEmAnotacao();
        visualizarTarefasPage.clicarEmApagarAnotacoes();
        visualizarTarefasPage.clicarEmApagarAnotacoesConfirmar();

        Assert.assertFalse(visualizarTarefasPage.retornaAnotacao());

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void editarAnotacoesVerTarefasComSucesso() throws FileNotFoundException {

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
        String anotacaoTexto = FakerUtils.gerarDescricaoAnotacoes();
        String anotacoesTextoModificado = FakerUtils.gerarDescricaoAnotacoesAlterada();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000" + idIssue);

        visualizarTarefasPage.preencherAnotacoes(anotacaoTexto);
        visualizarTarefasPage.clicarEmAdicionarAnotacao();
        visualizarTarefasPage.clicarEmAnotacao();
        visualizarTarefasPage.clicarEmEditarAnotacoes();

        visualizarTarefasPage.limparEPreencherAnotacoes(anotacoesTextoModificado);
        visualizarTarefasPage.clicarEmAtualizar();

        Assert.assertEquals(anotacoesTextoModificado, visualizarTarefasPage.verificarAnotacoes());

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        String idNote = TarefasDBSteps.retornarIdAnotacaoBug();
        String idNoteText = TarefasDBSteps.retornarIdTextoAnotacaoBug();
        TarefasDBSteps.deletarAnotacaoTextoBug(idNoteText);
        TarefasDBSteps.deletarAnotacaoBug(idNote);
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void adicionarMarcadorUmaTarefa() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        visualizarTarefasPage = new VisualizarTarefasPage();

        ProjetosDBSteps.inserirProjeto();
        String idProjeto = ProjetosDBSteps.retornarDadosProjeto().get(0);
        TarefasDBSteps.inserirTextoTarefa();
        String idTexto = TarefasDBSteps.retornaDadosTextoTarefa().get(0);
        TarefasDBSteps.inserirTarefa(idProjeto, idTexto);
        ArrayList<String> idsIssues = TarefasDBSteps.retornaDadosTodasIssueIdProjeto(idProjeto);
        String descricaoTag = FakerUtils.gerarTagNameAleatorio();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000" + idsIssues.get(0));

        visualizarTarefasPage.adicionarMarcadorIssue(descricaoTag);
        visualizarTarefasPage.clicarEmAplicar();

        Assert.assertEquals(descricaoTag, visualizarTarefasPage.verificarTag(descricaoTag));

        TarefasDBSteps.deletarTags();
        TarefasDBSteps.deletarBugTags();

        String idIssue = idsIssues.get(0);

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarBugTags();
        TarefasDBSteps.deletarTags();
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

    @Test
    public void apagarTarefasComSucesso() throws FileNotFoundException {

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

        mainPage.clicarEmMinhaVisao();
        mainPage.visualizarTarefaSelecionada("000"+idIssue);

        visualizarTarefasPage.clicarEmApagarTarefa();
        visualizarTarefasPage.clicarEmApagarTarefaConfirmar();

        Assert.assertFalse(mainPage.verificarLinkTarefa("000"+idIssue));

        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));
        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTextoIdTarefa(idTexto);

    }

}
