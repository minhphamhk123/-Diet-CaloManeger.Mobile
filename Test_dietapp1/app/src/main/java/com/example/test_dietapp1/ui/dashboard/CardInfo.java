package com.example.test_dietapp1.ui.dashboard;

import java.io.Serializable;

public class CardInfo implements Serializable {
    private String content;
    private String title;

    public CardInfo(String mTitle, String mContent) {
        this.content = mContent;
        this.title = mTitle;
    }

    public String getTitle() {
        return this.title;
    }
    public String getContent() {
        return this.content;
    }
    public void setTitle(String mTitle) {
        this.title = mTitle;
    }
    public void setContent(String mContent) {
        this.content = mContent;
    }
}
