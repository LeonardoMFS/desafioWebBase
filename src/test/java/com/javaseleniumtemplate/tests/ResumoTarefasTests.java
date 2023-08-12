package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.SummaryPage;
import com.javaseleniumtemplate.types.Arquivos;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ResumoTarefasTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    SummaryPage summaryPage;

    //Tests
    @Test
    public void retornaResumoComSucesso() throws FileNotFoundException {

        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        summaryPage = new SummaryPage();

        DadosUsuario usersDados = Arquivos.getJsonUsers();
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO,usersDados.getPasswordAdmin());

        mainPage.clicarEmResumoButton();

        Assert.assertTrue(summaryPage.retornaPaginaResumo());

    }

}
