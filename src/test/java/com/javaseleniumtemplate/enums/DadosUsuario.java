package com.javaseleniumtemplate.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.File;
import java.io.IOException;

@NoArgsConstructor(force = true)
public class DadosUsuario {
    @NonNull
    @JsonProperty("password")
    private String password;

    @NonNull
    @JsonProperty("password_admin")
    private String passwordAdmin;


    public static DadosUsuario get(String arquivo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(arquivo), DadosUsuario.class);
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

}
