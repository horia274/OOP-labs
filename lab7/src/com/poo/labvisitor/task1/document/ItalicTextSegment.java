package com.poo.labvisitor.task1.document;

public class ItalicTextSegment extends TextSegment {

    public ItalicTextSegment(String content) {
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
        return "ItalicTextSegment{" +
                "content='" + content + '\'' +
                '}';
    }
}
