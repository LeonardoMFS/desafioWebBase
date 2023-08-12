package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class GerenciarPerfisGlobaisPage extends PageBase {
    By perfisGlobaisButton = By.xpath("//a[text()='Gerenciar Perfís Globais']");
    By plataformaField = By.id("platform");
    By SONomeField = By.id("os");
    By SOVersaoField = By.id("os-version");
    By descricaoField = By.id("description");
    By adicionarPerfilButton = By.xpath("//input[@value='Adicionar Perfil']");

    public void clicarEmGerenciarPerfisGlobais() {
        click(perfisGlobaisButton);
    }

    public void preencherNomePlataforma(String plataforma) {
        sendKeys(plataformaField, plataforma);
    }

    public void preencherNomeSo(String SO) {
        sendKeys(SONomeField, SO);
    }

    public void preencherVersaoSo(String versao) {
        sendKeys(SOVersaoField, versao);
    }

    public void preencherDescricaoPerfil(String descricao) {
        sendKeys(descricaoField, descricao);
    }


    public void clicarEmCriarPerfilGlobal() {
        click(adicionarPerfilButton);
    }

    public boolean retornaPerfilGlobal(String perfil) {
        try {
            Select perfisGlobais = new Select(driver.findElement(By.id("select-profile")));
            perfisGlobais.selectByVisibleText(perfil);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
