package com.poo.labvisitor.task1.document;

public class UrlSegment extends TextSegment {
    private String url;
    private String description;

    public UrlSegment(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void accept(DocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "UrlSegment{" +
                "url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
