package com.dummy.mode.response;

public class Support {
    private String url;
    private String text;

    public Support() {
    }

    public Support(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Support [url=" + url + ", text=" + text + "]";
    }
}
