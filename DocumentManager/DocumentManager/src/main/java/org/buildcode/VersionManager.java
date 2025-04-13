package org.buildcode;

public interface VersionManager {
    void save(DocumentMemento documentMemento);

    DocumentMemento undo();
}