package org.buildcode;

public class TextDocument implements EditableDocument, VersionedDocument {
    private final String id;
    private Content content;
    private final User createdBy;
    private String lastUpdatedAt;

    private final VersionManager versionManager;

    public TextDocument(String id, User createdBy, VersionManager versionManager) {
        this.id = id;
        this.content = new TextContent();
        this.createdBy = createdBy;
        this.lastUpdatedAt = null;

        this.versionManager = versionManager;
    }

    @Override
    public void edit(Content content) {
        this.content.edit(content.getContent());
    }

    @Override
    public void update() {
        DocumentMemento documentMemento = save();
        versionManager.save(documentMemento);
        this.lastUpdatedAt = String.valueOf(System.currentTimeMillis());
    }

    @Override
    public Content view() {
        return this.content;
    }

    @Override
    public void revert() {
        DocumentMemento documentMemento = versionManager.undo();
        this.content = documentMemento.getContent();
    }

    @Override
    public User getCreatedBy() {
        return this.createdBy;
    }

    private DocumentMemento save() {
        return new DocumentMemento(content);
    }
}