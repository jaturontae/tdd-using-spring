package com.bank.service.internal;

import com.bank.service.TransferTimePolicy;

public class EndTimePolicy implements TransferTimePolicy{
    private int endHourTime = 22;

    public void setHourTime(int startHourTime) {
        this.endHourTime = startHourTime;
    }

    @Override
    public int getHourTime() {
        return this.endHourTime;
    }
}
