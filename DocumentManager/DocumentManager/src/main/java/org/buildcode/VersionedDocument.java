package org.buildcode;

public interface VersionedDocument extends Document {
    void update();
    void revert();
}