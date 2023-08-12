package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.FakerUtils;
import com.javaseleniumtemplate.utils.Utils;

public class CategoriaDBSteps {

    private static String queriesPath = "src/test/java/com/javaseleniumtemplate/queries/categoriaQueries/";

    public static void deletarCategoria(String name) {
        String query = Utils.getFileContent(queriesPath + "deleteCategoria.sql").replace("$name", name);
        DBUtils.getQueryResult(query);
    }

    public static void insereCategoria() {
        String query = Utils.getFileContent(queriesPath + "insertCategoria.sql");
        query = query.replace("$name", FakerUtils.gerarNomeCategoriaAleatorio());
        DBUtils.getQueryResult(query);
    }

    public static String retornaCategoriaName() {
        String query = Utils.getFileContent(queriesPath + "selectCategoria.sql");
        return DBUtils.getQueryResult(query).get(0);
    }


}
