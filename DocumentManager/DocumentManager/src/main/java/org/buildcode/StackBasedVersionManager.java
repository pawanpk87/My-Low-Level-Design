package org.buildcode;

import java.util.Stack;

public class StackBasedVersionManager implements VersionManager {
    private final Stack<DocumentMemento> history;

    public StackBasedVersionManager() {
        history = new Stack<>();
    }

    @Override
    public void save(DocumentMemento documentMemento) {
        history.push(documentMemento);
    }

    @Override
    public DocumentMemento undo() {
        if (history.isEmpty()) {
            throw new RuntimeException("No history found!");
        }
        return history.pop();
    }
}