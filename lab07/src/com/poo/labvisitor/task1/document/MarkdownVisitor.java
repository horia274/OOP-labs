package com.poo.labvisitor.task1.document;

public class MarkdownVisitor implements DocumentVisitor {
    StringBuilder stringBuilder;

    public MarkdownVisitor() {
        stringBuilder = new StringBuilder();
    }


    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        stringBuilder.append("_");
        stringBuilder.append(italicTextSegment.getContent());
        stringBuilder.append("_");
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        stringBuilder.append("__");
        stringBuilder.append(boldTextSegment.getContent());
        stringBuilder.append("__");
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        stringBuilder.append("[");
        stringBuilder.append(urlSegment.getDescription());
        stringBuilder.append("]");
        stringBuilder.append("(");
        stringBuilder.append(urlSegment.getUrl());
        stringBuilder.append(")");
    }

    @Override
    public void visit(PlainTextSegment plainTextSegment) {
        stringBuilder.append(plainTextSegment.getContent());
    }

    @Override
    public StringBuilder getDocument() {
        return stringBuilder;
    }
}
