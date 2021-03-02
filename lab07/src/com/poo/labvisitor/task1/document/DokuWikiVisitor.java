package com.poo.labvisitor.task1.document;

public class DokuWikiVisitor implements DocumentVisitor {
    private StringBuilder stringBuilder;

    public DokuWikiVisitor() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        stringBuilder.append("//");
        stringBuilder.append(italicTextSegment.getContent());
        stringBuilder.append("//");
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        stringBuilder.append("**");
        stringBuilder.append(boldTextSegment.getContent());
        stringBuilder.append("**");
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        stringBuilder.append("[[");
        stringBuilder.append(urlSegment.getUrl());
        stringBuilder.append("|");
        stringBuilder.append(urlSegment.getDescription());
        stringBuilder.append("]]");
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
