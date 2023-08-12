package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;

import org.openqa.selenium.By;

public class GerenciarProjetosPage extends PageBase {
    By gerenciarProjetosButton = By.xpath("//a[text()='Gerenciar Projetos']");
    By criarNovoProjetoButton = By.xpath("//button[text()='Criar Novo Projeto']");
    By nomeProjetoField = By.id("project-name");
    By adicionarProjetoButton = By.xpath("//input[@value='Adicionar projeto']");
    By categoriaLabelField = By.xpath("//input[@name='name']");
    By adicionarCategoriaButton = By.xpath("//input[@value='Adicionar Categoria']");
    By atualizarCategoriaButton = By.xpath("//input[@value='Atualizar Categoria']");
    By categoriaAlterar = By.id("proj-category-name");
    By apagarCategoriaConfirmarButton = By.xpath("//input[@value='Apagar Categoria']");
    String verificarCategoria = "//tr/td[text()='###']";
    String alterarCategoriaButton = "//tr/td[text()='###']/../td/div/div/form/fieldset/button[text()='Alterar']";
    String apagarCategoriaButton = "//tr/td[text()='###']/../td/div/div[2]/form/fieldset/button[text()='Apagar']";


    public void clicarEmGerenciarProjetos() {
        click(gerenciarProjetosButton);
    }

    public void clicarEmNovoProjeto() {
        click(criarNovoProjetoButton);
    }

    public void preencherNomeProjeto(String projeto) {
        sendKeys(nomeProjetoField, projeto);
    }

    public void clicarEmAdicionarProjeto() {
        click(adicionarProjetoButton);
    }

    public void preencherCategoria(String categoria) {
        sendKeys(categoriaLabelField, categoria);
    }

    public void clicarEmAdicionarCategoria() {
        click(adicionarCategoriaButton);
    }

    public String verificarSeACategoriaExiste(String categoria) {
        verificarCategoria = verificarCategoria.replace("###", categoria);
        return getText(By.xpath(verificarCategoria));
    }

    public boolean verificarSeACategoriaExisteApagar(String categoria) {
        verificarCategoria = verificarCategoria.replace("###", categoria);
        return returnIfElementExists(By.xpath(verificarCategoria));
    }

    public void selecionarCategoriaAlterar(String categoria) {
        alterarCategoriaButton = alterarCategoriaButton.replace("###", categoria);
        click(By.xpath(alterarCategoriaButton));
    }

    public void preencherCategoriaAlterar(String categoria) {
        clear(categoriaAlterar);
        sendKeys(categoriaAlterar, categoria);
    }

    public void selecionarCategoriaApagar(String categoria) {
        apagarCategoriaButton = apagarCategoriaButton.replace("###", categoria);
        click(By.xpath(apagarCategoriaButton));
    }

    public void clicarEmAtualizarCategoria() {
        click(atualizarCategoriaButton);
    }

    public void clicarEmApagarCategoria() {
        click(apagarCategoriaConfirmarButton);
    }

}
