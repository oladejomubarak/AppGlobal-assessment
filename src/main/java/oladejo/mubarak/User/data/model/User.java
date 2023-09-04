package oladejo.mubarak.User.data.model;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@RequiredArgsConstructor
public class User {
    @Id
    private String id;
    @Email
    private String email;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String password;
}
