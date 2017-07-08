package com.example.selenide.page.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


/**
 * Created by shima on 2017/06/18.
 */
public abstract class CheckInfoPageBase {

    protected SelenideElement ErrorCheckResult() {
        return $("#errorcheck_result");
    }

    protected SelenideElement Price() {
        return $("#price");
    }

    protected SelenideElement DateFrom() {
        return $("#datefrom");
    }

    protected SelenideElement DateTo() {
        return $("#dateto");
    }

    protected SelenideElement Dayscount() {
        return $("#dayscount");
    }

    protected SelenideElement Hc() {
        return $("#hc");
    }

    protected SelenideElement BfOrder() {
        return $("#bf_order");
    }

    protected SelenideElement PlanAOrder() {
        return $("#plan_a_order");
    }

    protected SelenideElement PlanBOrder() {
        return $("#plan_b_order");
    }

    protected SelenideElement GuestName() {
        return $("#gname");
    }

    protected SelenideElement Commit() {
        return $("#commit");
    }

    protected SelenideElement ReturnToIndex() {
        return $("#returnto_index");
    }

}
