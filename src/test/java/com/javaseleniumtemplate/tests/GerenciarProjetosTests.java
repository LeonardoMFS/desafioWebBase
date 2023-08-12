package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.CategoriaDBSteps;
import com.javaseleniumtemplate.dbsteps.ProjetosDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.GerenciarProjetosPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.SelecionarProjetoPage;
import com.javaseleniumtemplate.types.Arquivos;
import com.javaseleniumtemplate.utils.ExecutarJavaScriptNode;
import com.javaseleniumtemplate.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class GerenciarProjetosTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    GerenciarProjetosPage gerenciarProjetosPage;
    SelecionarProjetoPage selecionarProjetoPage;

    //Tests
    @Test
    public void criarProjetoComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarProjetosPage = new GerenciarProjetosPage();

        String nomeProjeto = FakerUtils.gerarNomeProjetoAleatorio();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarProjetosPage.clicarEmGerenciarProjetos();
        gerenciarProjetosPage.clicarEmNovoProjeto();

        gerenciarProjetosPage.preencherNomeProjeto(nomeProjeto);
        gerenciarProjetosPage.clicarEmAdicionarProjeto();


        Assert.assertEquals(nomeProjeto, ProjetosDBSteps.retornarNomeProjeto());

        ProjetosDBSteps.deletarProjeto(nomeProjeto);

    }

    @Test
    public void criarProjetoDBComSucesso() throws FileNotFoundException {

        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        selecionarProjetoPage = new SelecionarProjetoPage();

        //Parameters
        ProjetosDBSteps.inserirProjeto();
        String projectName = ProjetosDBSteps.retornarNomeProjeto();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        selecionarProjetoPage.clicarEmGerenciarProjetos(projectName);

        String nomeProjeto = projectName.replace(" ", "");
        Assert.assertEquals(nomeProjeto, selecionarProjetoPage.retornaSeValido(projectName).replace(" ", ""));

        ProjetosDBSteps.deletarProjeto(projectName);

    }
    @Test
    public void criarProjetoComJavaScript() throws FileNotFoundException {

        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarProjetosPage = new GerenciarProjetosPage();

        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());


        mainPage.clicarEmGerenciar();

        gerenciarProjetosPage.clicarEmGerenciarProjetos();
        gerenciarProjetosPage.clicarEmNovoProjeto();

        String nomeProjeto = "PROJETO" + ExecutarJavaScriptNode.gerarNomeAleatorio();
        gerenciarProjetosPage.preencherNomeProjeto(nomeProjeto);
        gerenciarProjetosPage.clicarEmAdicionarProjeto();


        Assert.assertEquals(nomeProjeto, ProjetosDBSteps.retornarNomeProjeto());

        ProjetosDBSteps.deletarProjeto(nomeProjeto);
    }


    @Test
    public void criarCategoriaComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarProjetosPage = new GerenciarProjetosPage();

        //Parameters
        String categoria = FakerUtils.gerarNomeCategoriaAleatorio();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());


        mainPage.clicarEmGerenciar();

        gerenciarProjetosPage.clicarEmGerenciarProjetos();

        gerenciarProjetosPage.preencherCategoria(categoria);
        gerenciarProjetosPage.clicarEmAdicionarCategoria();

        Assert.assertEquals(categoria, gerenciarProjetosPage.verificarSeACategoriaExiste(categoria));

        CategoriaDBSteps.deletarCategoria(categoria);
    }

    @Test
    public void editarCategoriaComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarProjetosPage = new GerenciarProjetosPage();

        //Parameters
        CategoriaDBSteps.insereCategoria();
        String categoria = CategoriaDBSteps.retornaCategoriaName();
        String categoriaAlterada = FakerUtils.gerarNomeCategoriaAlterado();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarProjetosPage.clicarEmGerenciarProjetos();
        gerenciarProjetosPage.selecionarCategoriaAlterar(categoria);
        gerenciarProjetosPage.preencherCategoriaAlterar(categoriaAlterada);
        gerenciarProjetosPage.clicarEmAtualizarCategoria();

        Assert.assertEquals(categoriaAlterada, gerenciarProjetosPage.verificarSeACategoriaExiste(categoriaAlterada));

        CategoriaDBSteps.deletarCategoria(categoriaAlterada);
    }


    @Test
    public void deletarCategoriaComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarProjetosPage = new GerenciarProjetosPage();

        //Parameters
        CategoriaDBSteps.insereCategoria();
        String categoria = CategoriaDBSteps.retornaCategoriaName();
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarProjetosPage.clicarEmGerenciarProjetos();
        gerenciarProjetosPage.selecionarCategoriaApagar(categoria);
        gerenciarProjetosPage.clicarEmApagarCategoria();

        Assert.assertFalse(gerenciarProjetosPage.verificarSeACategoriaExisteApagar(categoria));
    }

}
