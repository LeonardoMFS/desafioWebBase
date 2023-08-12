package com.javaseleniumtemplate.utils;

import com.github.javafaker.Faker;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class FakerUtils {

    private static final Locale LOCALE_US = new Locale("en-US");

    public static String gerarNomeAleatorio(){
            Faker faker = new Faker(LOCALE_US);
            return faker.name().firstName();
        }

        public static String gerarNomeCompletoAleatorio(){
            Faker faker = new Faker(LOCALE_US);
            return faker.name().firstName() +" "+ faker.name().lastName().replace("'","");
        }
        public static String gerarEmailAleatorio(){
            Faker faker = new Faker(LOCALE_US);
            return faker.internet().emailAddress();
        }

    public static String gerarNumeroAleatorio(){
        return String.valueOf(new Random().nextInt(100));

    }

    public static String gerarStringAleatoria(int i){

        byte[] bytearray;
        String mystring;
        StringBuilder thebuffer;

        bytearray = new byte[256];
        new Random().nextBytes(bytearray);

        mystring = new String(bytearray, StandardCharsets.UTF_8);

        // Create the StringBuffer
        thebuffer = new StringBuilder();

        for (int m = 0; m < mystring.length(); m++) {

            char n = mystring.charAt(m);

            if (((n >= 'A' && n <= 'Z')
                    || (n >= '0' && n <= '9'))
                    && (i > 0)) {

                thebuffer.append(n);
                i--;
            }
        }

        // resulting string
        return thebuffer.toString();
    }

      public static String gerarNomeProjetoAleatorio() {
        return "Projeto" + " " + FakerUtils.gerarStringAleatoria(3) + FakerUtils.gerarNumeroAleatorio();

    }

    public static String gerarNomeMarcadorAleatorio() {
        return "Marcador" + " " + FakerUtils.gerarStringAleatoria(3) + FakerUtils.gerarNumeroAleatorio();

    }

    public static String gerarDescricaoAleatoria() {
      return "Descrição" + " " + FakerUtils.gerarStringAleatoria(17);
    }

    public static String gerarData() {
        int i = (int) (new Date().getTime()/1000);
        return String.valueOf(i);
    }

    public static String gerarNomePlataformaAleatorio() { return "Plataforma" + " " + FakerUtils.gerarStringAleatoria(3);}

    public static String gerarNomeOSAleatorio() { return "Windows" + " " + FakerUtils.gerarStringAleatoria(3);}

    public static String gerarVersaoOSAleatoria() { return "Versão"+ " " + FakerUtils.gerarNumeroAleatorio();}

    public static String gerarSumarioIssueAleatoria() {
        return "Sumário" + " " + "V" + FakerUtils.gerarStringAleatoria(10);
    }

    public static String gerarDescricaoTextoAlterado() {
        return "Descrição Alterada" + " " + FakerUtils.gerarStringAleatoria(22);
    }

    public static String gerarDescricaoAnotacoes() {
        return "Anotações" + " " + FakerUtils.gerarStringAleatoria(20);
    }

    public static String gerarDescricaoAnotacoesAlterada() {
        return "Anotações Alteradas" + " " + FakerUtils.gerarStringAleatoria(22);
    }

    public static String gerarTagNameAleatorio() {
        return "Tag" + " " + FakerUtils.gerarStringAleatoria(4);

    }

    public static String gerarNomeCategoriaAleatorio() {
        return "Categoria" + " " + FakerUtils.gerarStringAleatoria(5);

    }
    public static String gerarNomeCategoriaAlterado() {
        return "Categoria Alterada" + " " + FakerUtils.gerarStringAleatoria(7);

    }
}
