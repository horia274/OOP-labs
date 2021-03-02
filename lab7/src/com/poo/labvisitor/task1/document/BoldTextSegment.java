package com.poo.labvisitor.task1.document;

public class BoldTextSegment extends TextSegment {

    public BoldTextSegment(String content) {
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
        return "BoldTextSegment{" +
                "content='" + content + '\'' +
                '}';
    }
}
