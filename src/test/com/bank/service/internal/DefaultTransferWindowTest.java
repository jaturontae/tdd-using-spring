package com.bank.service.internal;

import net.sf.cglib.core.Local;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class DefaultTransferWindowTest {
    //private final
    @Test
    public void withinValidTransferWindow() {
        CurrentTime currentTime = new CurrentTime("12:05:59");
        DefaultTransferWindow transferWindow = new DefaultTransferWindow("10:00:00", "22:00:00");
        Assert.assertTrue(transferWindow.isValidTimeForTransferMoney(currentTime.getCurrentTime()));
    }

    @Test
    public void withinInValidTransferWindow() {
        CurrentTime currentTime = new CurrentTime("22:05:59");
        DefaultTransferWindow transferWindow = new DefaultTransferWindow("10:00:00", "22:00:00");
        Assert.assertFalse(transferWindow.isValidTimeForTransferMoney(currentTime.getCurrentTime()));
    }

    class CurrentTime{
        private String specificTime = null;
        public CurrentTime(String initial){
            this.specificTime = initial;
        }

        public LocalTime getCurrentTime() {
            if(this.specificTime != null)
                return LocalTime.parse(this.specificTime);
            return LocalTime.now();
        }
    }

    class DefaultTransferWindow {
        private LocalTime open;
        private LocalTime close;
        public DefaultTransferWindow(String open, String close) {
            this.open = LocalTime.parse(open);
            this.close = LocalTime.parse(close);
        }

        public boolean isValidTimeForTransferMoney(LocalTime transactionTime) {
            return (transactionTime.isAfter(open))&&(transactionTime.isBefore(close));
        }
    }
}
