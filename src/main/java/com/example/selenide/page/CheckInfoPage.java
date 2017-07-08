package com.example.selenide.page;


import com.example.selenide.page.base.CheckInfoPageBase;

import java.util.Date;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by shima on 2017/06/18.
 */
public class CheckInfoPage extends CheckInfoPageBase {

    public String getErrorCheckResult() {
        return ErrorCheckResult().text();
    }

    public String getPrice(){
        return Price().text();
    }

    public String getDateFrom(){
        return DateFrom().text();
    }

    public String getDateTo(){
        return DateTo().text();
    }

    public String getDaysCount(){
        return Dayscount().text();
    }

    public String getHeadcount(){
        return Hc().text();
    }

    public String getBfOrder(){
        return BfOrder().text();
    }

    public String getPlanAOrder(){
        return PlanAOrder().text();
    }

    public String getPlanBOrder(){
        return PlanBOrder().text();
    }

    public String getGuestName(){
        return GuestName().text();
    }

    public FinalConfirmPage doCommit(){
        Commit().click();
        return page(FinalConfirmPage.class);
    }

    public InputPage doReturnToIndex(){
        ReturnToIndex().click();
        return page(InputPage.class);
    }

}
