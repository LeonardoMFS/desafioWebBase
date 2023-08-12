package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class TarefasPage extends PageBase {
    String atribuido = "//a[text()=###]";

    public Boolean retornaTarefaAtribuida(String idIssue) {
        atribuido = atribuido.replace("###", idIssue);
        return returnIfElementIsDisplayed(By.xpath(atribuido));
    }

}
