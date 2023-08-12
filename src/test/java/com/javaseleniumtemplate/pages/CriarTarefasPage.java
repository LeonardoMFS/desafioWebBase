package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class CriarTarefasPage extends PageBase {
    By resumoField = By.id("summary");
    By descricaoField = By.id("description");
    By criarNovaTarefaButton = By.xpath("//input[@value='Criar Nova Tarefa']");
    By fazerUploadButton = By.xpath("//input[@type='file']");
    By dropZoneField = By.xpath("//div[@class='dropzone center dz-clickable']/span");

    public void preencherResumoArea(String resumo) {
        sendKeys(resumoField, resumo);
    }

    public void preencherDescricaoArea(String descricao) {
        sendKeys(descricaoField, descricao);
    }

    public void clicarEmNovaTarefa() {
        click(criarNovaTarefaButton);
    }

    public void clicarNoDropBox() {
        dropBox(fazerUploadButton);
    }

    public void clicarEmEnviarArquivoButton() {
        click(dropZoneField);
    }

    public void preencherArquivo(String file) {
        sendKeys(fazerUploadButton, file);
    }

}
