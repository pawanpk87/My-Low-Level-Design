package org.buildcode;

public class TextDocumentFactory implements DocumentFactory {

    private final VersionManager versionManager;

    public TextDocumentFactory(VersionManager versionManager) {
        this.versionManager = versionManager;
    }

    @Override
    public Document createDocument(String id, User user) {
        return new TextDocument(id, user, versionManager);
    }
}