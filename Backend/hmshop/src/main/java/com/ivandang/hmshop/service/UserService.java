package com.ivandang.hmshop.service;

import com.ivandang.hmshop.dto.UpdateUserDTO;
import com.ivandang.hmshop.dto.UserDTO;
import com.ivandang.hmshop.exceptions.DataNotFoundException;
import com.ivandang.hmshop.model.User;

public interface UserService {
    User createUser(UserDTO userDTO) throws Exception;
    String login(String phoneNumber, String password, Long roleId) throws Exception;
    User getUserDetailsFromToken(String token) throws Exception;
    User updateUser(Long userId, UpdateUserDTO updatedUserDTO) throws Exception;
}
