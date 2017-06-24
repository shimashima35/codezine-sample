package com.example.selenide;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.example.selenide.page.CheckInfoPage;
import com.example.selenide.page.FinalConfirmPage;
import com.example.selenide.page.InputPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class SampleTest {

    @Before
    public void before(){
        Configuration.browser = WebDriverRunner.MARIONETTE;
        //Configuration.browser = "edge";
        System.setProperty("webdriver.gecko.driver","C:/Users/shima/bin/geckodriver.exe");
    }

    @Test
    public void 三ヶ月以上先の予約はできない() {
        InputPage inputPage = open("http://example.selenium.jp/reserveApp/", InputPage.class);
        inputPage.setReserveYear("2020");
        inputPage.setReserveMonth("12");
        inputPage.setReserveDay("24");
        inputPage.setReserveTerm("2");
        inputPage.setBreakfastOn();
        inputPage.setGuestName("東京 太郎");
        inputPage.setPlanA(true);
        inputPage.setPlanA(true);
        CheckInfoPage checkPage = inputPage.clickGotoNext();
        assertEquals("宿泊日には、3ヶ月以内のお日にちのみ指定できます。", checkPage.getErrorCheckResult());
    }


}
