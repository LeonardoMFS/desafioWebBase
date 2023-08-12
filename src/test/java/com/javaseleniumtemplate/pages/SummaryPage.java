package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class SummaryPage extends PageBase {
    By resumoButton = By.xpath("//ul[@class='nav nav-tabs padding-18']/li/a");

    public boolean retornaPaginaResumo() {
        return returnIfElementExists(resumoButton);
    }


}
