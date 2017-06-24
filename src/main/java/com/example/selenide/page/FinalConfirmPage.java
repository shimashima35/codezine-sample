package com.example.selenide.page;


import com.example.selenide.page.base.FinalConfirmPageBase;

/**
 * Created by shima on 2017/06/18.
 */
public class FinalConfirmPage extends FinalConfirmPageBase {

    public String getErrorCheckResult() {
        return ErrorCheckResult().text();
    }

}
