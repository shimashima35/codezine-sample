package com.example.selenide.page;

import com.example.selenide.page.base.InputPageBase;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Created by shima on 2017/06/18.
 */
public class InputPage extends InputPageBase {

    public String getReserveYear() {
        return ReserveYear().val();
    }

    public void setReserveYear(String year) {
        ReserveYear().val(year);
    }

    public String getReserveMonth() {
        return ReserveMonth().val();
    }

    public void setReserveMonth(String month) {
        ReserveMonth().val(month);
    }

    public String getReserveDay() {
        return ReserveDay().val();
    }

    public void setReserveDay(String day) {
        ReserveDay().val(day);
    }

    public String getReserveTerm() {
        return ReserveTerm().val();
    }

    public void setReserveTerm(String term) {
        ReserveTerm().val(term);
    }

    public String getHeadcount() {
        return Headcount().val();
    }

    public void setHeadcount(String count) {
        Headcount().val(count);
    }

    public boolean isBreakfastOn() {
        return BreakfastOn().is(selected);
    }

    public void setBreakfastOn() {
        BreakfastOn().click();
    }

    public boolean isBreakfastOff() {
        return BreakfastOff().is(selected);
    }

    public void setBreakfastOff() {
        BreakfastOff().click();
    }

    public boolean isPlanA() {
        return PlanA().is(selected);
    }

    public void setPlanA(boolean check) {
        PlanA().setSelected(check);
    }

    public boolean isPlanB() {
        return PlanB().is(selected);
    }

    public void setPlanB(boolean check) {
        PlanB().setSelected(check);
    }

    public String getGuestName() {
        return GuestName().val();
    }

    public void setGuestName(String name) {
        GuestName().val(name);
    }

    public CheckInfoPage clickGotoNext() {
        GotoNext().click();
        return page(CheckInfoPage.class);
    }

}
