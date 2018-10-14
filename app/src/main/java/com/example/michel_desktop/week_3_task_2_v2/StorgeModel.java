package com.example.michel_desktop.week_3_task_2_v2;

import java.io.Serializable;

public class StorgeModel implements Serializable {
    private final String TEXT;
    private final String URL;

    public StorgeModel(String TEXT, String URL) {
        this.TEXT = TEXT;
        this.URL = URL;
    }

    public String getTEXT() {
        return TEXT;
    }

    public String getURL() {
        return URL;
    }
}
