package com.example.selenide;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

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
    public void test01() {
        open("http://example.selenium.jp/reserveApp/");
    }


}
