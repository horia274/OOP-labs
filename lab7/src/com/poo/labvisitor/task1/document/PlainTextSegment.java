package com.poo.labvisitor.task1.document;

public class PlainTextSegment extends TextSegment {

    public PlainTextSegment(String content) {
        super(content);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void accept(DocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "PlainTextSegment{" +
                "content='" + content + '\'' +
                '}';
    }
}
