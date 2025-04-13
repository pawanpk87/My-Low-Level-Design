package org.buildcode;

public class DocumentProxy implements EditableDocument, VersionedDocument {
    private final Document document;
    private final User user;

    public DocumentProxy(Document document, User user) {
        this.document = document;
        this.user = user;
    }

    @Override
    public void edit(Content content) {
        if(!isAuthorized(user)) {
            throw new RuntimeException("Unauthorized access!");
        }
        ((EditableDocument) document).edit(content);
    }

    @Override
    public void update() {
        if(!isAuthorized(user)) {
            throw new RuntimeException("Unauthorized access!");
        }
        ((VersionedDocument) document).update();
    }

    @Override
    public Content view() {
        return document.view();
    }

    @Override
    public void revert() {
        if(!isAuthorized(user)) {
            throw new RuntimeException("Unauthorized access!");
        }
        ((VersionedDocument) document).revert();
    }

    @Override
    public User getCreatedBy() {
        return document.getCreatedBy();
    }

    private boolean isAuthorized(User user) {
        return document.getCreatedBy().getUserId().equals(user.getUserId());
    }
}