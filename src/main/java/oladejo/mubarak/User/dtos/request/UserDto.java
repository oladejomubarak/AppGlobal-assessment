package oladejo.mubarak.User.dtos.request;

import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String password;

}
