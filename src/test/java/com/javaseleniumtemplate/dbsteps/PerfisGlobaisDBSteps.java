package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.Utils;

public class PerfisGlobaisDBSteps {

    private static String queriesPath = "src/test/java/com/javaseleniumtemplate/queries/perfisGlobaisQueries/";

    public static void deletarPerfisGlobais(String platform) {
        String query = Utils.getFileContent(queriesPath + "deletePerfisGlobais.sql").replace("$platform", platform);
        DBUtils.getQueryResult(query);
    }

    public static String retornaPlataforma() {
        String query = Utils.getFileContent(queriesPath + "selectPerfisGlobais.sql");
        return DBUtils.getQueryResult(query).get(0);
    }
}
