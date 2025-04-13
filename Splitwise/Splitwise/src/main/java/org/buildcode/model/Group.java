package org.buildcode.model;

import java.util.List;

public class Group {
    private String name;
    private List<User> members;
    private User createdBy;

    public List<User> getMembers() {
        return this.members;
    }

    public String getName() {
        return this.name;
    }

    public void addMember(User user) {
        // add member
    }

    public void removeMember(User user) {
        // remove member
    }
}