package com.example.selenide.page;


import com.example.selenide.page.base.CheckInfoPageBase;

import java.util.Date;

/**
 * Created by shima on 2017/06/18.
 */
public class CheckInfoPage extends CheckInfoPageBase {

    public String getPrice(){
        return Price().val();
    }

    public String getDateFrom(){
        return DateFrom().val();
    }

    public String getDateTo(){
        return DateTo().val();
    }

    public String getDaysCount(){
        return Dayscount().val();
    }

    public String getHeadcount(){
        return Hc().val();
    }

    public String getBfOrder(){
        return BfOrder().val();
    }

    public String getPlanAOrder(){
        return PlanAOrder().val();
    }

    public String getPlanBOrder(){
        return PlanBOrder().val();
    }

    public String getGuestName(){
        return GuestName().val();
    }

    public void doCommit(){
        Commit().click();
    }

    public void doReturnToIndex(){
        ReturnToIndex().click();
    }

}
