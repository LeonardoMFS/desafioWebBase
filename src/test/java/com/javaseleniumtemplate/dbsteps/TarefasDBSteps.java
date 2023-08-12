package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.FakerUtils;
import com.javaseleniumtemplate.utils.Utils;

import java.util.ArrayList;

public class TarefasDBSteps {
    private static String queriesPath = "src/test/java/com/javaseleniumtemplate/queries/issueQueries/";

    public static void inserirTarefa(String projectId, String idTexto) {
        String query = Utils.getFileContent(queriesPath + "insertIssue.sql");
        query = query.replace("$project_id", projectId);
        query = query.replace("$bug_text_id", idTexto);
        query = query.replace("$summary", FakerUtils.gerarSumarioIssueAleatoria());
        query = query.replace("$date_submitted", FakerUtils.gerarData());
        query = query.replace("$last_updated", FakerUtils.gerarData());
        DBUtils.getQueryResult(query);
    }

    public static void inserirTarefaHandlerId(String projectId, String idTexto) {
        String query = Utils.getFileContent(queriesPath + "insertIssueHandler.sql");
        query = query.replace("$project_id", projectId);
        query = query.replace("$bug_text_id", idTexto);
        query = query.replace("$summary", FakerUtils.gerarSumarioIssueAleatoria());
        query = query.replace("$date_submitted", FakerUtils.gerarData());
        query = query.replace("$last_updated", FakerUtils.gerarData());
        DBUtils.getQueryResult(query);
    }

    public static void inserirTarefaResolvida(String projectId, String idTexto) {
        String query = Utils.getFileContent(queriesPath + "insertIssueResolvido.sql");
        query = query.replace("$project_id", projectId);
        query = query.replace("$bug_text_id", idTexto);
        query = query.replace("$summary", FakerUtils.gerarSumarioIssueAleatoria());
        query = query.replace("$date_submitted", FakerUtils.gerarData());
        query = query.replace("$last_updated", FakerUtils.gerarData());
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornaDadosTarefa() {
        String queryResultado = Utils.getFileContent(queriesPath + "selectDadosIssue.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static ArrayList<String> retornaDadosTextoTarefa() {
        String queryResultado = Utils.getFileContent(queriesPath + "selectDadosTexto.sql");
        return DBUtils.getQueryResult(queryResultado);
    }

    public static void inserirTextoTarefa() {
        String query = Utils.getFileContent(queriesPath + "insertTextoIssue.sql");
        query = query.replace("$description", FakerUtils.gerarDescricaoAleatoria());
        DBUtils.getQueryResult(query);
    }

    public static void deletarTarefaId(String idIssue) {
        String query = Utils.getFileContent(queriesPath + "deleteIssueTodas.sql");
        query = query.replace("$idIssue", idIssue);
        DBUtils.getQueryResult(query);
    }

    public static void deletarTextoIdTarefa(String idTexto) {
        String query = Utils.getFileContent(queriesPath + "deleteTextoTodos.sql");
        query = query.replace("$idTexto", idTexto);
        DBUtils.getQueryResult(query);
    }

    public static void inserirMonitoramentoTarefa(String idIssue) {
        String query = Utils.getFileContent(queriesPath + "insertMonitoramentoAdm.sql");
        query = query.replace("$bug_id", idIssue);
        DBUtils.getQueryResult(query);
    }

    public static void deletarMonitoramentoTarefa(String idIssue) {
        String query = Utils.getFileContent(queriesPath + "deleteMonitoramento.sql");
        query = query.replace("$bug_id", idIssue);
        DBUtils.getQueryResult(query);
    }

    public static void inserirTarefaUrgente(String projectId, String idTexto) {
        String query = Utils.getFileContent(queriesPath + "insertIssueUrgente.sql");
        query = query.replace("$project_id", projectId);
        query = query.replace("$bug_text_id", idTexto);
        query = query.replace("$summary", FakerUtils.gerarSumarioIssueAleatoria());
        query = query.replace("$date_submitted", FakerUtils.gerarData());
        query = query.replace("$last_updated", FakerUtils.gerarData());
        DBUtils.getQueryResult(query);
    }

    public static String retornarIdAnotacaoBug() {
        String query = Utils.getFileContent(queriesPath + "selectIdNote.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static String retornarIdTextoAnotacaoBug() {
        String query = Utils.getFileContent(queriesPath + "selectdNoteText.sql");
        return DBUtils.getQueryResult(query).get(0);
    }

    public static void deletarAnotacaoTextoBug(String idNoteText) {
        String query = Utils.getFileContent(queriesPath + "deleteBugNoteText.sql");
        query = query.replace("$idNoteText", idNoteText);
        DBUtils.getQueryResult(query);
    }

    public static void deletarAnotacaoBug(String idNote) {
        String query = Utils.getFileContent(queriesPath + "deleteBugNote.sql");
        query = query.replace("$idNote", idNote);
        DBUtils.getQueryResult(query);
    }

    public static void deletarTextoTarefa() {
        String query = Utils.getFileContent(queriesPath + "deleteTexto.sql");
        DBUtils.getQueryResult(query);
    }

    public static void deletarBugTextoTarefa() {
        String query = Utils.getFileContent(queriesPath + "deleteNoteText.sql");
        DBUtils.getQueryResult(query);
    }

    public static ArrayList<String> retornaDadosTodasIssueIdProjeto(String idProjeto) {
        String queryResultado = Utils.getFileContent(queriesPath + "selectDadosTodasIssueProjeto.sql");
        queryResultado = queryResultado.replace("$project_id", idProjeto);
        return DBUtils.getQueryResult(queryResultado);
    }

    public static void deletarRelacionamento(String idIssue) {
        String query = Utils.getFileContent(queriesPath + "deleteRelationship.sql");
        query = query.replace("$source_bug_id", idIssue);
        DBUtils.getQueryResult(query);
    }

    public static void deletarTags() {
        String query = Utils.getFileContent(queriesPath + "deleteTags.sql");
        DBUtils.getQueryResult(query);
    }

    public static void deletarBugTags() {
        String query = Utils.getFileContent(queriesPath + "deleteBugTags.sql");
        DBUtils.getQueryResult(query);
    }

    public static void deletarHistoricoBug(String idBugHistory) {
        String query = Utils.getFileContent(queriesPath + "deleteBugHistory.sql");
        query = query.replace("$bug_id", idBugHistory);
        DBUtils.getQueryResult(query);
    }

    public static void deletarAttachment() {
        String query = Utils.getFileContent(queriesPath + "deleteAttachment.sql");
        DBUtils.getQueryResult(query);
    }

}
