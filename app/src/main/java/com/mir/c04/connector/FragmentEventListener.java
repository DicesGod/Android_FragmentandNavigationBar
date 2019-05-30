package com.mir.c04.connector;

import com.mir.c04.model.User;

public interface FragmentEventListener {

    void onUserAdded(User user);

    void onUserUpdated(String oldEmail, User newUser);

    void onUserListClicked(User user);
}
