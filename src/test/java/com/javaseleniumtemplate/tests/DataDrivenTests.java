package com.javaseleniumtemplate.tests;


import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.MarcadorDBSteps;
import com.javaseleniumtemplate.dbsteps.ProjetosDBSteps;
import com.javaseleniumtemplate.dbsteps.TarefasDBSteps;
import com.javaseleniumtemplate.dbsteps.UsuariosDBSteps;
import com.javaseleniumtemplate.enums.DadosUsuario;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.*;
import com.javaseleniumtemplate.types.Arquivos;
import com.javaseleniumtemplate.utils.ReadExcellUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class DataDrivenTests extends TestBase {

    LoginFlows loginFlows;
    MainPage mainPage;
    GerenciarProjetosPage gerenciarProjetosPage;
    GerenciarMarcadorPage gerenciarMarcadorPage;
    GerenciarUsuariosPage gerenciarUsuariosPage;
    CriarTarefasPage criarTarefasPage;
    VisualizarTarefasPage visualizarTarefasPage;

    public static HSSFRow Row;
    public static HSSFCell cell;
    public static String FILE_PATH = "src/test/resources/files/xls/ProjetoSheet.xls";
    public static String FILE_PATH_2 = "src/test/resources/files/xls/MarcadorSheet.xls";
    public static String FILE_PATH_3 = "src/test/resources/files/xls/UsuarioSheet.xls";
    public static String FILE_PATH_4 = "src/test/resources/files/xls/TarefaSheet.xls";
    public static String SHEET_NAME = "TestData";
    public static HSSFSheet Sheet;
    ReadExcellUtil ex = new ReadExcellUtil();

    @DataProvider
    public static Object[][] getProjetoData() throws Exception {

        Sheet = ReadExcellUtil.DataSheet(FILE_PATH, SHEET_NAME);

        int records = Sheet.getPhysicalNumberOfRows();
        int rows = 1;

        Object[][] values = new Object[records][rows];
        for (int j = 0; j < (records); j++) {
            if (Sheet.getRow(j) != null) {
                values[j][rows - 1] = String.valueOf(Sheet.getRow(j).getCell(rows - 1));
            }
        }

        return values;
    }

    @DataProvider
    public static Object[][] getMarcadorData() throws Exception {

        Sheet = ReadExcellUtil.DataSheet(FILE_PATH_2, SHEET_NAME);

        int records = Sheet.getPhysicalNumberOfRows();
        int rows = 2;

        Object[][] values = new Object[records][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < (records); j++) {
                if (Sheet.getRow(j) != null) {
                    values[j][i] = String.valueOf(Sheet.getRow(j).getCell(i));
                }
            }
        }
        return values;
    }

    @DataProvider
    public static Object[][] getUsuarioData() throws Exception {

        Sheet = ReadExcellUtil.DataSheet(FILE_PATH_3, SHEET_NAME);
        int records = Sheet.getPhysicalNumberOfRows();
        int rows = 3;

        Object[][] values = new Object[records][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < (records); j++) {
                if (Sheet.getRow(j) != null) {
                    values[j][i] = String.valueOf(Sheet.getRow(j).getCell(i));
                }
            }
        }
        return values;
    }

    @DataProvider
    public static Object[][] getTarefaData() throws Exception {

        Sheet = ReadExcellUtil.DataSheet(FILE_PATH_4, SHEET_NAME);
        // Get username and passsword from testdata.xls
        int records = Sheet.getPhysicalNumberOfRows();
        int rows = 2;

        Object[][] values = new Object[records][rows];
        //loop over the rows
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < (records); j++) {
                if (Sheet.getRow(j) != null) {
                    values[j][i] = String.valueOf(Sheet.getRow(j).getCell(i));
                }
            }
        }
        return values;
    }


    @Test(dataProvider = "getProjetoData")
    public void criarProjetoComSucesso(String projetoName) throws Exception {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarProjetosPage = new GerenciarProjetosPage();

        //Paraneters
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarProjetosPage.clicarEmGerenciarProjetos();
        gerenciarProjetosPage.clicarEmNovoProjeto();

        gerenciarProjetosPage.preencherNomeProjeto(projetoName);
        gerenciarProjetosPage.clicarEmAdicionarProjeto();

        Assert.assertEquals(projetoName, ProjetosDBSteps.retornarNomeProjeto());

        ProjetosDBSteps.deletarProjeto(projetoName);

    }


    @Test(dataProvider = "getMarcadorData")
    public void criarMarcadorComSucesso(String marcadorName, String descricao) throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarMarcadorPage = new GerenciarMarcadorPage();

        //Paraneters
        DadosUsuario usersDados = Arquivos.getJsonUsers();

        //Test
        loginFlows.efetuarLogin(GlobalStaticParameters.USER_PADRAO, usersDados.getPasswordAdmin());

        mainPage.clicarEmGerenciar();

        gerenciarMarcadorPage.clicarEmGerenciarMarcador();
        gerenciarMarcadorPage.preencherNomeMarcador(marcadorName);
        gerenciarMarcadorPage.preencherDescricao(descricao);
        gerenciarMarcadorPage.clicarEmCriarMarcador();


        Assert.assertEquals(marcadorName, MarcadorDBSteps.retornaNomeMarcador());

        MarcadorDBSteps.deletarMarcador(marcadorName);

    }


    @Test(dataProvider = "getUsuarioData")
    public void criarUsuarioComSucesso(String username, String fullName, String email) throws FileNotFoundException {

        //Object Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        gerenciarUsuariosPage = new GerenciarUsuariosPage();

        //Paraneters
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

    @Test(dataProvider = "getTarefaData")
    public void criarTarefaComSucesso(String sumario, String descricao) throws FileNotFoundException, InterruptedException {

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

        criarTarefasPage.preencherResumoArea(sumario);
        criarTarefasPage.preencherDescricaoArea(descricao);
        criarTarefasPage.clicarEmNovaTarefa();

        String idIssue = TarefasDBSteps.retornaDadosTarefa().get(0);
        String tarefa = visualizarTarefasPage.retornaSeTarefaExiste(idIssue);

        Assert.assertEquals(idIssue, tarefa.replaceFirst("^0+(?!$)", ""));

        TarefasDBSteps.deletarTarefaId(idIssue);
        TarefasDBSteps.deletarHistoricoBug(idIssue);
        TarefasDBSteps.deletarTextoTarefa();
        ProjetosDBSteps.deletarProjeto(ProjetosDBSteps.retornarDadosProjeto().get(1));

    }


}
