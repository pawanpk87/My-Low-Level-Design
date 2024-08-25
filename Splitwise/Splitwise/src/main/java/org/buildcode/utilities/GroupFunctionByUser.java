package org.buildcode.utilities;

import org.buildcode.model.Group;
import org.buildcode.model.User;

import java.util.List;

public interface GroupFunctionByUser {
    Group createGroup(String groupName);
    void joinGroup(String groupName);
    void sendGroupInvitation(String groupName, List<User> users);
}
