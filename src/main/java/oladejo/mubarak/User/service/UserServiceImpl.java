package oladejo.mubarak.User.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oladejo.mubarak.User.data.model.User;
import oladejo.mubarak.User.data.repository.UserRepo;
import oladejo.mubarak.User.dtos.request.UserDto;
import oladejo.mubarak.User.exception.UserRegistrationException;
import oladejo.mubarak.User.utils.Validators;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    @Override
    public User register(UserDto userDto) {
        boolean existingUser = userRepo.existsByEmailIgnoreCase(userDto.getEmail());
        boolean existingByPhoneNumber = userRepo.existsByPhoneNumber(userDto.getPhoneNumber());
        Validators.isValidPhoneNumber(userDto.getPhoneNumber());
        if(Objects.equals(existingUser, true)){
            throw new UserRegistrationException("user with such email already exists");
        }
        if(Objects.equals(existingByPhoneNumber, true)){
            throw new UserRegistrationException("user with such phoneNumber already exists");
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPassword(userDto.getPassword());
        return userRepo.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findUserByEmailIgnoreCase(email).orElseThrow(()-> new UserRegistrationException("user not found"));
    }

    @Override
    public User findUserByPhoneNumber(String phoneNumber) {
        return userRepo.findUserByPhoneNumber(phoneNumber).orElseThrow(()-> new UserRegistrationException("user not found"));
    }

    @Override
    public User updateUserInfo(String email, UserDto userDto) {
        User user = findUserByEmail(email);
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(userDto, user);
        userRepo.save(user);
        return user;
    }

    @Override
    public void deleteUser(String email) {
        User user = findUserByEmail(email);
        userRepo.delete(user);
    }
}
