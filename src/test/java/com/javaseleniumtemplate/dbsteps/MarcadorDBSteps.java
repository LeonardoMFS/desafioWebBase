package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.FakerUtils;
import com.javaseleniumtemplate.utils.Utils;

public class MarcadorDBSteps {

    private static String queriesPath = "src/test/java/com/javaseleniumtemplate/queries/marcadorQueries/";


    public static String retornaNomeMarcador() {
        String query = Utils.getFileContent(queriesPath + "selectMarcador.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static void deletarMarcador(String name) {
        String query = Utils.getFileContent(queriesPath + "deleteMarcador.sql").replace("$name", name);
        DBUtils.getQueryResult(query);
    }

    public static void inserirMarcador() {
        String query = Utils.getFileContent(queriesPath + "insertMarcador.sql");
        query = query.replace("$name", FakerUtils.gerarNomeMarcadorAleatorio());
        query = query.replace("$description", FakerUtils.gerarDescricaoAleatoria());
        query = query.replace("$date_created", FakerUtils.gerarData());
        query = query.replace("$date_updated", FakerUtils.gerarData());
        DBUtils.getQueryResult(query);
    }

}
