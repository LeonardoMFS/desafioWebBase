package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class GerenciarMarcadorPage extends PageBase {
    By gerenciarMarcadorButton = By.xpath("//a[text()='Gerenciar Marcadores']");
    By nomeMarcadorButton = By.id("tag-name");
    By descricaoField = By.id("tag-description");
    By criarMarcadorButton = By.xpath("//input[@value='Criar Marcador']");
    By apagarMarcadorButton = By.xpath("//input[@value='Apagar Marcador']");
    String selecionarMarcador = "//a[text()='###']";


    public void clicarEmGerenciarMarcador() {
        click(gerenciarMarcadorButton);
    }

    public void preencherNomeMarcador(String marcador) {
        sendKeys(nomeMarcadorButton, marcador);
    }

    public void preencherDescricao(String descricaoTexto) {
        sendKeys(descricaoField, descricaoTexto);
    }

    public void clicarEmCriarMarcador() {
        click(criarMarcadorButton);
    }

    public void selecionarMarcador(String nomeMarcador) {
        selecionarMarcador = selecionarMarcador.replace("###", nomeMarcador);
        click(By.xpath(selecionarMarcador));
    }

    public void clicarEmApagarMarcador() {
        click(apagarMarcadorButton);
    }

    public boolean retornaMarcador(String nomeMarcador) {
        selecionarMarcador = selecionarMarcador.replace("###", nomeMarcador);

        try {
            click(By.xpath(selecionarMarcador));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
