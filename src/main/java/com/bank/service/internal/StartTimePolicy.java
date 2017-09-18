package com.bank.service.internal;

import com.bank.service.TransferTimePolicy;

public class StartTimePolicy implements TransferTimePolicy{
    private int startHourTime = 6;

    public void setHourTime(int startHourTime) {
        this.startHourTime = startHourTime;
    }

    @Override
    public int getHourTime() {
        return this.startHourTime;
    }
}
