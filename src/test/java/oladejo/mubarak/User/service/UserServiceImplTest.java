package oladejo.mubarak.User.service;

import oladejo.mubarak.User.data.model.User;
import oladejo.mubarak.User.dtos.request.UserDto;
import oladejo.mubarak.User.exception.UserRegistrationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    private UserDto userDto;



    @BeforeEach void setUp(){
        userDto = new UserDto();
        userDto.setEmail("admin@gmail.com");
        userDto.setFirstname("Mubarak");
        userDto.setLastname("Oladejo");
        userDto.setPhoneNumber("08162768079");
        userDto.setPassword("password");
    }
    @Test void testThatUserCanRegister(){
        User user =userService.register(userDto);
        assertEquals("admin@gmail.com", user.getEmail());
    }

    @Test void testThatRegisteredUserCanBeFound(){
        User user = userService.findUserByEmail("admin@gmail.com");
        assertEquals("Mubarak", user.getFirstname());
    }
    @Test void testThatUserInfoCanBeUpdated(){
        UserDto userDto2 = new UserDto();
        userDto2.setFirstname("Ade");
        User updatedUser = userService.updateUserInfo("admin@gmail.com", userDto2);
        assertEquals("Ade", updatedUser.getFirstname());
    }
@Test void testThatUserCanBeDeleted(){
        userService.deleteUser("admin@gmail.com");
    assertNull(userService.findUserByEmail("admin@gmail.com"));
}
}