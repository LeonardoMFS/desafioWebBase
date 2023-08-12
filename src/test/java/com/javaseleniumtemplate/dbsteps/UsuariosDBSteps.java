package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.Utils;
import com.javaseleniumtemplate.utils.FakerUtils;

public class UsuariosDBSteps {

    private static String queriesPath = "src/test/java/com/javaseleniumtemplate/queries/userQueries/";

    public static void inserirUsuario() {
        String query = Utils.getFileContent(queriesPath + "insertUser.sql");
        query = query.replace("$username", FakerUtils.gerarNomeAleatorio());
        query = query.replace("$realname", FakerUtils.gerarNomeCompletoAleatorio());
        query = query.replace("$email", FakerUtils.gerarEmailAleatorio());
        DBUtils.getQueryResult(query);
    }

    public static String retornarPrimeiroNomeUsuario() {
        String query = Utils.getFileContent(queriesPath + "selectUserName.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static void deletarUsuario(String usuario) {
        String query = Utils.getFileContent(queriesPath + "deleteUser.sql").replace("$usuario", usuario);
        DBUtils.getQueryResult(query);
    }

    public static String retornarEmailUsuario() {
        String query = Utils.getFileContent(queriesPath + "selectUserEmail.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static void deletarEmailUsuario(String email) {
        String query = Utils.getFileContent(queriesPath + "deleteUserEmail.sql").replace("$email", email);
        DBUtils.getQueryResult(query);
    }
}
