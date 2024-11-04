package com.ivandang.hmshop.service;

import com.ivandang.hmshop.dto.UserDTO;
import com.ivandang.hmshop.exceptions.DataNotFoundException;
import com.ivandang.hmshop.model.User;

public interface UserService {
    User createUser(UserDTO userDTO) throws DataNotFoundException;
    String login(String phoneNumber, String password);
}
