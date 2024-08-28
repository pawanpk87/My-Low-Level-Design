package org.buildcode;

public class TextContent implements Content {
    private String content;

    @Override
    public void edit(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public Content clone() {
        TextContent clonedTextDocument = new TextContent();
        clonedTextDocument.edit(this.content);
        return clonedTextDocument;
    }

    @Override
    public String toString() {
        return "TextContent{" +
                "content='" + content + '\'' +
                '}';
    }
}