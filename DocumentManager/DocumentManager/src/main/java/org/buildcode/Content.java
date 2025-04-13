package org.buildcode;

public interface Content {
    void edit(String content);
    String getContent();
    Content clone();
}