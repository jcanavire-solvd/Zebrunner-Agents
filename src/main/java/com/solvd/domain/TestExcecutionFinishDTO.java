package com.solvd.domain;

import com.solvd.utils.DateFormatter;

public class TestExcecutionFinishDTO {
    private String result;
    private String endedAt;

    public TestExcecutionFinishDTO(String result) {
        this.result = result;
        this.endedAt = DateFormatter.getCurrentTime();
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getEndedAt() {
        return endedAt;
    }
    public void setEndedAt(String endedAt) {
        this.endedAt = endedAt;
    }
}
