package com.example.selenide.page.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


/**
 * Created by shima on 2017/06/18.
 */
public abstract class FinalConfirmPageBase {

    protected SelenideElement ErrorCheckResult() {
        return $("#errorcheck_result");
    }

    protected SelenideElement ReturnToCheckInfo() {
        return $("#returnto_checkInfo");
    }


}
