package com.example.draw;

import java.time.LocalDateTime;
import java.util.List;

public class DrawRecord {
    private String memberName;
    private LocalDateTime drawTime;
    private int drawsCount;
    private Object[] results;

    public DrawRecord(String memberName, LocalDateTime drawTime, int drawsCount, Object[] results) {
        this.memberName = memberName;
        this.drawTime = drawTime;
        this.drawsCount = drawsCount;
        this.results = results;
    }

    public String getMemberName() {
        return memberName;
    }

    public LocalDateTime getDrawTime() {
        return drawTime;
    }

    public int getDrawsCount() {
        return drawsCount;
    }

    public Object[] getResults() {
        return results;
    }




}
