package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VisualizarTarefasPage extends PageBase {
    By imprimirTarefaButton = By.xpath("//a[text()='Print Reports']");
    By tarefaIDField = By.xpath("//td[@class='bug-id']");
    By textoDescricaoField = By.xpath("//td/textarea[@id='description']");
    By atualizarButton = By.xpath("//input[@value='Atualizar Informação']");
    By apagarTarefaButton = By.xpath("//input[@value='Apagar']");
    By apagarTarefaConfirmarButton = By.xpath("//input[@value='Apagar Tarefas']");
    By copiarTarefaButton = By.xpath("//input[@value='Criar Clone']");
    By criarNovaTarefaCopiada = By.xpath("//input[@value='Criar Nova Tarefa']");
    By filtrarMonitoradosButton = By.xpath("//a[text()='Monitorado Por']");
    By monitoradoPorSelect = By.name("monitor_user_id[]");
    By aplicarFiltroButton = By.xpath("//input[@value='Aplicar Filtro']");
    By filtrarResolvidoButton = By.xpath("//a[text()='Atribuído a']");
    By selecionarResolvidoButton = By.name("handler_id[]");
    By filtrarPrioridadeButton = By.xpath("//a[text()='Prioridade']");
    By prioridadeButton = By.name("priority[]");
    By redefinirFiltroButton = By.xpath("(//a[@href='view_all_set.php?type=0'])[2]");
    By textoAnotacoesField = By.xpath("//textarea[@name='bugnote_text']");
    By adicionarAnotacaoButton = By.xpath("//input[@value='Adicionar Anotação']");
    By anotacoesTextButton = By.xpath("//td[@class='bugnote-note bugnote-public']");
    By apagarButton = By.xpath("//button[text()='Apagar']");
    By editarButton = By.xpath("//button[text()='Alterar']");
    By confirmarApagarAnotacaoButton = By.xpath("//input[@value='Apagar Anotação']");
    By selecionarUmaAcao = By.name("action");
    By clicarOk = By.xpath("//input[@value='OK']");
    By fecharTarefaButton = By.xpath("//input[@value='Fechar Tarefas']");
    By estadoButton = By.xpath("//a[text()='Estado']");
    By selecionarEstadoFechadoFiltro = By.name("status[]");
    By alterarStatusButton = By.xpath("//input[@value='Alterar Status:']");
    By confirmarResolverTarefaButton = By.xpath("//input[@value='Resolver Tarefa']");
    By verificarResolucao = By.xpath("//td[@class = 'bug-status']");
    By statusButton = By.name("new_status");
    By usuarioButton = By.name("handler_id");
    By atribuirUsuarioButton = By.xpath("//input[@value='Atribuir a:']");
    By relacionarTarefa = By.name("dest_bug_id");
    By adicionarRelacaoButton = By.xpath("(//input[@value='Adicionar'])[1]");
    By adicionarMarcador = By.name("tag_string");
    By clicarAplicar = By.xpath("//input[@value='Aplicar']");
    By clicarEmExportar = By.xpath("//a[text()='CSV Export']");
    By clicarEmExportarExcel = By.xpath("//a[text()='Excel Export']");
    By clicarEmPrint = By.xpath("//a[text()='Print Reports']");
    By clicarEmWord = By.xpath("//i[@title='Word 2000']");
    By paraApagarButton = By.xpath("//span[@class='label label-sm label-default arrowed-in-right']");
    String editarProjetoLink = "//div[@id='unassigned']/div[@class='widget-body']/div[@class='widget-main no-padding']/div[@class='table-responsive']/table/tbody/tr/td/a[text()=###]/.././a[@class='edit']";
    String descricaoValidar = "//*[text()='###']";
    String labelVerificarTag = "//a[text()='###']";
    String verificarRelacoes = "//a[@href='/view.php?id=###']";
    String verificarRelacoesResolvidas="//a[@href='/view.php?id=###']";
    String verificarRelacoesMonitoradas="//a[@href='/view.php?id=###']";
    String relacoesSub ="//a[@href='view.php?id=###']";
    String tarefaSelecionadaButton = "//a[@href='/view.php?id=###']/parent::td/parent::tr/td/div/label/span";
    By checkBoxTarefa = By.xpath("//td[@class = 'column-selection']//div//label//span[@class = 'lbl']");
    String selecionarUsuario = "//td[@class='bug-assigned-to']/a[text()='###']";


    public String retornaNomeTarefa() {
        return getText(tarefaIDField);
    }

    public void editarProjeto(String idProjeto) {
        editarProjetoLink = editarProjetoLink.replace("###", idProjeto);
        click(By.xpath(editarProjetoLink));
    }
    public void adicionarNovaDescricao(String descricao) {
        clear(textoDescricaoField);
        sendKeys(textoDescricaoField, descricao);
    }

    public String validarTextoModificado(String texto) {
        descricaoValidar = descricaoValidar.replace("###", texto);
        return getText(By.xpath(descricaoValidar));
    }

    public void clicarEmAtualizar() {
        click(atualizarButton);
    }

    public void clicarEmApagarTarefa() {
        click(apagarTarefaButton);
    }

    public void clicarEmApagarTarefaConfirmar() {
        click(apagarTarefaConfirmarButton);
    }

    public void clicarEmCopiarTarefa() {
        click(copiarTarefaButton);
    }

    public void clicarEmCriarNovaTarefaCopiada() {
        click(criarNovaTarefaCopiada);
    }

    public String retornaSeTarefaExiste(String idIssue) {
        verificarRelacoes = verificarRelacoes.replace("###", idIssue);
        waitForElement(By.xpath(verificarRelacoes));
        return getText(By.xpath(verificarRelacoes));
    }

    public String verificarSeExisteTarefaSub(String idIssue) {
        relacoesSub = relacoesSub.replace("###", idIssue);
        waitForElement(By.xpath(relacoesSub));
        return getText(By.xpath(relacoesSub));
    }

    public String verificarSeExisteTarefaResolvida(String idIssue) {
        verificarRelacoesResolvidas = verificarRelacoesResolvidas.replace("###", idIssue);
        return getText(By.xpath(verificarRelacoesResolvidas));
    }

    public String verificarSeExisteTarefaMonitorada(String idIssue) {
        verificarRelacoesMonitoradas = verificarRelacoesMonitoradas.replace("###", idIssue);
        return getText(By.xpath(verificarRelacoesMonitoradas));
    }

    public void clicarEmRelacionados() {
        click(filtrarResolvidoButton);
    }

    public void selecionarRelacionados(String index) {
        comboBoxSelectByIndex(selecionarResolvidoButton, index);
    }

    public void clicarEmMonitoradoPor() {
        click(filtrarMonitoradosButton);
    }

    public void selecionarTipoMonitoramento(String index) {
        comboBoxSelectByIndex(monitoradoPorSelect, index);
    }

    public void clicarEmAplicarFiltro() {
        click(aplicarFiltroButton);
    }

    public void clicarEmRedefinirFiltro() {
        click(redefinirFiltroButton);
    }

    public void clicarEmPrioridade() {
        click(filtrarPrioridadeButton);
    }

    public void selecionarPrioridade(String index) {
        comboBoxSelectByIndex(prioridadeButton, index);
    }

    public void preencherAnotacoes(String anotacoes) {
        sendKeys(textoAnotacoesField, anotacoes);
    }

    public void clicarEmAdicionarAnotacao() {
        click(adicionarAnotacaoButton);
    }

    public void clicarEmAnotacao() {
        waitForElement(anotacoesTextButton);
        click(anotacoesTextButton);
    }

    public void clicarEmApagarAnotacoes() {
        mouseOver(paraApagarButton);
        click(apagarButton);
    }

    public void clicarEmApagarAnotacoesConfirmar() {
        click(confirmarApagarAnotacaoButton);
    }

    public String verificarAnotacoes() {
        return getText(anotacoesTextButton);
    }

    public boolean retornaAnotacao() {
        return returnIfElementExists(anotacoesTextButton);
    }

    public void clicarEmEditarAnotacoes() {
        mouseOver(paraApagarButton);
        click(editarButton);
    }

    public void limparEPreencherAnotacoes(String anotacoesNote) {
        clear(textoAnotacoesField);
        sendKeys(textoAnotacoesField, anotacoesNote);
    }

    public void selecionarUmaTarefa() {
        click(checkBoxTarefa);

    }

    public void clicarEmSelecionarUmaAcao(String acao) {
        comboBoxSelectByVisibleText(selecionarUmaAcao, acao);
    }

    public void clicarEmOK() {
        click(clicarOk);
    }

    public void clicarEmFecharTarefa() {
        click(fecharTarefaButton);
    }

    public void clicarEmEstado() {
        click(estadoButton);
    }

    public void selecionarEstado(String index) {
        comboBoxSelectByIndex(selecionarEstadoFechadoFiltro, index);
    }

    public void clicarEmAlterarStatus() {
        click(alterarStatusButton);
    }

    public void clicarEmResolverTarefa() {
        click(confirmarResolverTarefaButton);
    }

    public String verificarSeEstaResolvido() {
        return getText(verificarResolucao);
    }

    public void clicarEmSelecionarUmStatus(String index) {
        comboBoxSelectByIndex(statusButton, index);
    }

    public void clicarEmSelecionarUmUsuarioAtribuido(String index) {
        comboBoxSelectByVisibleText(usuarioButton, index);
    }

    public void clicarEmSelecionarUmUsuario() {
        click(atribuirUsuarioButton);
    }

    public String verificarSelecionarUmUsuario(String nomeUsuario) {
        selecionarUsuario = selecionarUsuario.replace("###", nomeUsuario);
        waitForElement(By.xpath(selecionarUsuario));
        return getText(By.xpath(selecionarUsuario));
    }

    public void preencherTarefaRelacionada(String idTarefa) {
        sendKeys(relacionarTarefa, idTarefa);
    }

    public void adicionarRelacao() {
        click(adicionarRelacaoButton);
    }

    public void adicionarMarcadorIssue(String idMarcador) {
        sendKeys(adicionarMarcador, idMarcador);
    }

    public void clicarEmAplicar() {
        click(clicarAplicar);
    }

    public String verificarTag(String descricaoTag) {
        labelVerificarTag = labelVerificarTag.replace("###", descricaoTag);
        waitForElement(By.xpath(labelVerificarTag));
        return getText(By.xpath(labelVerificarTag));
    }

    public void retornaElementoAlterarUsuario() {
        wait.until(ExpectedConditions.presenceOfElementLocated(atribuirUsuarioButton));
    }


}
