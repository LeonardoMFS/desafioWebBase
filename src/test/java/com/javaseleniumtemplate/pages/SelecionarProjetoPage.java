package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;


public class SelecionarProjetoPage extends PageBase {

    String textoDropDown = "//a[@data-toggle='dropdown' and contains(text(),'###')]";
    String projectDropDown = "dropdown_projects_menu";

    public void clicarEmGerenciarProjetos(String projectName) {
        selecionarItemDropDown(projectName, projectDropDown);
    }

    public String retornaSeValido(String projectName) {
        textoDropDown = textoDropDown.replace("###", projectName);
        return getText(By.xpath(textoDropDown));
    }

}
