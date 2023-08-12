package com.javaseleniumtemplate;

import com.javaseleniumtemplate.utils.FakerUtils;

public class GlobalStaticParameters {

    public static String FILE_PATH = "/temp";
    public static String DESCRIPTION = "Descrição" + " " + FakerUtils.gerarNumeroAleatorio();

    public static String USER_PADRAO = "administrator";
    public static String USER = "teste@gmail.com";
    public static String USER_CARACTER_ESPECIAL = "ab&*#!@gmail.com";
    public static String SENHA_ERRADA = "123446";

    public static String ERRO_URUARIO_MSG = "APPLICATION ERROR #805";
    public static String EMAIL_ERRO_MSG = "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.";


    public static String MONITORAMENTO_01 = "1";
    public static String FILTRO_URGENTE = "50";
    public static String ACAO ="Fechar";
    public static String STATUS_FECHADO = "90";
    public static String STATUS_RESOLVIDO = "80";
    public static String RESOLVIDO = "resolvido";

    public static String ANEXO = "src/test/resources/files/";
    public static String FILE = "teste.txt";


}

