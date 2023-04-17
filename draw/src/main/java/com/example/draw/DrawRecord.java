package com.example.draw;

import java.time.LocalDateTime;
import java.util.List;

public class DrawRecord {
    private LocalDateTime dateTime;
    private Object result;

    public DrawRecord(LocalDateTime dateTime, Object result) {
        this.dateTime = dateTime;
        this.result = result;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Object getResult() {
        return result;
    }
}
