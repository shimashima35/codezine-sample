package com.example.selenide;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.example.selenide.page.CheckInfoPage;
import com.example.selenide.page.FinalConfirmPage;
import com.example.selenide.page.InputPage;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Unit test for simple App.
 */
public class SampleTest {

    @Before
    public void before(){
        Configuration.browser = WebDriverRunner.GECKO;
    }

    @Test
    public void 正常系確認() {
        InputPage inputPage = open("http://example.selenium.jp/reserveApp/", InputPage.class);
        inputPage.setReserveYear("2017");
        inputPage.setReserveMonth("10");
        inputPage.setReserveDay("1");
        inputPage.setReserveTerm("2");
        inputPage.setBreakfastOn();
        inputPage.setGuestName("東京太郎");
        inputPage.setPlanA(false);
        inputPage.setPlanA(false);
        CheckInfoPage checkPage = inputPage.clickGotoNext();
        assertThat(checkPage.getErrorCheckResult(), is(""));
        assertThat(checkPage.getDateFrom(), is("2017年10月1日"));
        assertThat(checkPage.getDateTo(), is("2017年10月3日"));
        assertThat(checkPage.getDaysCount(), is("2"));
        assertThat(checkPage.getHeadcount(), is("1"));
        assertThat(checkPage.getBfOrder(), is("あり"));
        assertThat(checkPage.getGuestName(), is("東京太郎"));
        assertThat(checkPage.getPrice(), is("17750"));
        FinalConfirmPage finalPage = checkPage.doCommit();
        assertThat(finalPage.getErrorCheckResult(), is(""));
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
