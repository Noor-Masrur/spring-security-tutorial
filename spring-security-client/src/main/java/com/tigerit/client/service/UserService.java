package com.tigerit.client.service;

import com.tigerit.client.entity.User;
import com.tigerit.client.model.UserModel;

public interface UserService {
    public User registerUser(UserModel userModel);

    public void saveVerificationTokenForUser(String token, User user);
}
