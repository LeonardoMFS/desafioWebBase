package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class MainPage extends PageBase {

    //Mapping
    By usernameLoginInfoTextArea = By.xpath("//span[@class='user-info']");
    By emailErroMsg = By.xpath("//div[@class='alert alert-danger']/p");
    By perdeuSenhaButton = By.xpath("//a[text()='Perdeu a sua senha?']");
    By emailResetField = By.id("email-field");
    By gerenciarButton = By.xpath("//i[@class='menu-icon fa fa-gears']");
    By verTarefasButton = By.xpath("//i[@class='menu-icon fa fa-list-alt']");
    By criarTarefasButton = By.xpath("//i[@class='menu-icon fa fa-edit']");
    By resumoButton = By.xpath("//i[@class='menu-icon fa fa-bar-chart-o']");
    By minhaVisaoButton = By.xpath("//i[@class='menu-icon fa fa-dashboard']");
    By atribuidosParaMimButton = By.xpath("//div[@id='assigned']/div[@class='widget-header widget-header-small']/div[@class='widget-toolbar no-border hidden-xs']/div[@class='widget-menu']/a[text()='Ver Tarefas']");
    By naoAtribuidosAMimButton = By.xpath("//div[@id='unassigned']/div[@class='widget-header widget-header-small']/div[@class='widget-toolbar no-border hidden-xs']/div[@class='widget-menu']/a[text()='Ver Tarefas']");
    By relatadosPorMimButton = By.xpath("//div[@id='reported']/div[@class='widget-header widget-header-small']/div[@class='widget-toolbar no-border hidden-xs']/div[@class='widget-menu']/a[text()='Ver Tarefas']");
    By resolvidosPorMimButton = By.xpath("//div[@id='resolved']/div[@class='widget-header widget-header-small']/div[@class='widget-toolbar no-border hidden-xs']/div[@class='widget-menu']/a[text()='Ver Tarefas']");
    By monitoradoPorMimButton = By.xpath("//div[@id='monitored']/div[@class='widget-header widget-header-small']/div[@class='widget-toolbar no-border hidden-xs']/div[@class='widget-menu']/a[text()='Ver Tarefas']");
    By modificadosPorMimButton = By.xpath("//div[@id='recent_mod']/div[@class='widget-header widget-header-small']/div[@class='widget-toolbar no-border hidden-xs']/div[@class='widget-menu']/a[text()='Ver Tarefas']");
    By logoutButton = By.xpath("//a[@href='/logout_page.php']");
    By adminDropDown = By.xpath("(//a[@class='dropdown-toggle'])[2]");
    By projetoDropDown = By.xpath("(//a[@class='dropdown-toggle'])[1]");
    By projetoButon = By.xpath("//a[@class = 'project-link']");

    String detalhesTarefaText = "//div[@id='unassigned']/div[@class='widget-body']/div[@class='widget-main no-padding']/div[@class='table-responsive']/table/tbody/tr/td/a[text()=###]";

    //Actions
    public String retornaUsernameDasInformacoesDeLogin() {
        return getText(usernameLoginInfoTextArea);
    }

    public String retornaMensagemErro() {
        return getText(emailErroMsg);
    }

    public void clicarEmEsqueceuSenha() {
        click(perdeuSenhaButton);
    }

    public boolean verificarSeExisteOCampoEmail() {
        return returnIfElementExists(emailResetField);
    }

    public void clicarEmGerenciar() {
        click(gerenciarButton);
    }

    public void clicarEmVerTarefas() {
        click(verTarefasButton);
    }

    public void clicarEmCriarTarefas() {
        click(criarTarefasButton);
    }

    public void clicarEmResumoButton() {
        click(resumoButton);
    }

    public void clicarVerTarefasAtribuidasAMimNaoResolvida() {
        click(atribuidosParaMimButton);
    }

    public void clicarVerTarefasNaoAtribuidasAMim() {
        click(naoAtribuidosAMimButton);
    }

    public void clicarVerTarefasRelatadasPorMim() {
        click(relatadosPorMimButton);
    }

    public void clicarVerTarefasResolvidas() {
        click(resolvidosPorMimButton);
    }

    public void clicarVerTarefasMonitoradas() {
        click(monitoradoPorMimButton);
    }

    public void clicarEmMinhaVisao() {
        click(minhaVisaoButton);
    }

    public void clicarVerTarefasModificadas() {
        click(modificadosPorMimButton);
    }

    public void visualizarTarefaSelecionada(String idIssue) {
        detalhesTarefaText = detalhesTarefaText.replace("###", idIssue);
        click(By.xpath(detalhesTarefaText));
    }

    public boolean verificarLinkTarefa(String idIssue) {
        detalhesTarefaText = detalhesTarefaText.replace("###", idIssue);
        return returnIfElementExists(By.xpath(detalhesTarefaText));
    }

    public void clicarEmSair() {
        click(logoutButton);
    }

    public void clicarEmAdministrador() {
        click(adminDropDown);
    }

    public void clicarEmProjetos() {
        click(projetoDropDown);
    }

    public void selecionarProjeto() {
        click(projetoButon);
    }



}
