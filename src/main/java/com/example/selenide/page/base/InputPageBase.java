package com.example.selenide.page.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;


/**
 * Created by shima on 2017/06/18.
 */
public abstract class InputPageBase {

    protected SelenideElement ReserveYear() {
        return $("#reserve_year");
    }

    protected SelenideElement ReserveMonth() {
        return $("#reserve_month");
    }

    protected SelenideElement ReserveDay() {
        return $("#reserve_day");
    }

    protected SelenideElement ReserveTerm() {
        return $("#reserve_term");
    }

    protected SelenideElement Headcount() {
        return $("#headcount");
    }

    protected SelenideElement BreakfastOn() {
        return $("#breakfast_on");
    }

    protected SelenideElement BreakfastOff() {
        return $("#breakfast_off");
    }

    protected SelenideElement PlanA() {
        return $("#plan_a");
    }

    protected SelenideElement PlanB() {
        return $("#plan_b");
    }

    protected SelenideElement GuestName() {
        return $("#guestname");
    }

    protected SelenideElement GotoNext() {
        return $("#goto_next");
    }
}
