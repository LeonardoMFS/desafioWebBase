package com.javaseleniumtemplate.types;

import com.javaseleniumtemplate.enums.DadosUsuario;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Arquivos {

    public static DadosUsuario getJsonUsers() throws FileNotFoundException{
        try{
            return DadosUsuario.get("src/test/resources/json/userDados.json");

        } catch (FileNotFoundException ex) {
           throw new FileNotFoundException("Não foi possível fazer a leitura do arquivo");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
