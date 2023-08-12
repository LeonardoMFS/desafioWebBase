package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.GlobalStaticParameters;
import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.FakerUtils;
import com.javaseleniumtemplate.utils.Utils;

import java.util.ArrayList;

public class ProjetosDBSteps {

    private static String queriesPath = "src/test/java/com/javaseleniumtemplate/queries/projectQueries/";

    public static void inserirProjeto() {
        String query = Utils.getFileContent(queriesPath + "insertProject.sql");
        query = query.replace("$name", FakerUtils.gerarNomeProjetoAleatorio());
        query = query.replace("$file_path", GlobalStaticParameters.FILE_PATH);
        query = query.replace("$description", GlobalStaticParameters.DESCRIPTION);
        DBUtils.getQueryResult(query);
    }

    public static String retornarNomeProjeto() {
        String query = Utils.getFileContent(queriesPath + "selectProject.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static void deletarProjeto(String name) {
        String query = Utils.getFileContent(queriesPath + "deleteProject.sql").replace("$name", name);
        DBUtils.getQueryResult(query);
    }


    public static ArrayList<String> retornarDadosProjeto() {
        String queryResultado = Utils.getFileContent(queriesPath + "selectDadosProjeto.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

}
