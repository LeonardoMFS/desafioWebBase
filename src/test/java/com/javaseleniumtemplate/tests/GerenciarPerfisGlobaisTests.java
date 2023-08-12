package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.PerfisGlobaisDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.GerenciarPerfisGlobaisPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.types.Arquivos;
import com.javaseleniumtemplate.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class GerenciarPerfisGlobaisTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    GerenciarPerfisGlobaisPage gerenciarPerfisGlobaisPage;

    //Tests
    @Test
    public void criarPerfisGlobaisComSucesso() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarPerfisGlobaisPage = new GerenciarPerfisGlobaisPage();

        //Parameters
        DadosUsuario usersDados = Arquivos.getJsonUsers();
        String nomePlataforma = FakerUtils.gerarNomePlataformaAleatorio();
        String nomeSO = FakerUtils.gerarNomeOSAleatorio();
        String nomeVersaoSO = FakerUtils.gerarVersaoOSAleatoria();
        String descricao = FakerUtils.gerarDescricaoAleatoria();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarPerfisGlobaisPage.clicarEmGerenciarPerfisGlobais();
        gerenciarPerfisGlobaisPage.preencherNomePlataforma(nomePlataforma);
        gerenciarPerfisGlobaisPage.preencherNomeSo(nomeSO);
        gerenciarPerfisGlobaisPage.preencherVersaoSo(nomeVersaoSO);
        gerenciarPerfisGlobaisPage.preencherDescricaoPerfil(descricao);
        gerenciarPerfisGlobaisPage.clicarEmCriarPerfilGlobal();

        Assert.assertEquals(nomePlataforma, PerfisGlobaisDBSteps.retornaPlataforma());

        PerfisGlobaisDBSteps.deletarPerfisGlobais(nomePlataforma);

    }

    @Test
    public void criarPerfisGlobaisSemInformarDadosObrigatorios() throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarPerfisGlobaisPage = new GerenciarPerfisGlobaisPage();

        //Parameters
        DadosUsuario usersDados = Arquivos.getJsonUsers();
        String nomePlataforma = FakerUtils.gerarNomePlataformaAleatorio();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarPerfisGlobaisPage.clicarEmGerenciarPerfisGlobais();
        gerenciarPerfisGlobaisPage.clicarEmCriarPerfilGlobal();

        Assert.assertFalse(gerenciarPerfisGlobaisPage.retornaPerfilGlobal(nomePlataforma));

    }

}
