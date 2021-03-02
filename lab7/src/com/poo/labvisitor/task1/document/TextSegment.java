package com.poo.labvisitor.task1.document;

/**
 * Represents a text segment of a document that needs to be parsed.
 */
public abstract class TextSegment {
    protected String content;

    public TextSegment(String content) {
        this.content = content;
    }

    public TextSegment() {}

    public String getContent() {
        return content;
    }

    // TODO add method for applying the visitor
    public abstract void accept(DocumentVisitor documentVisitor);
}
