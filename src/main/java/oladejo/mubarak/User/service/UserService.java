package oladejo.mubarak.User.service;

import oladejo.mubarak.User.data.model.User;
import oladejo.mubarak.User.dtos.request.UserDto;

public interface UserService {
    User register(UserDto userDto);
    User findUserByEmail(String email);
    User findUserByPhoneNumber(String phoneNumber);
    User updateUserInfo(String email, UserDto userDto);
    void deleteUser(String email);
}
