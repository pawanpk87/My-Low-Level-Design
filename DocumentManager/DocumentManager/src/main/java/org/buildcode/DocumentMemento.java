package org.buildcode;

public class DocumentMemento {
    private final Content content;

    public DocumentMemento(Content content) {
        this.content = content.clone();
    }

    public Content getContent() {
        return this.content;
    }
}