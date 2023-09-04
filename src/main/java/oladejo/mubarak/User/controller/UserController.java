package oladejo.mubarak.User.controller;

import lombok.RequiredArgsConstructor;
import oladejo.mubarak.User.dtos.request.UserDto;
import oladejo.mubarak.User.exception.UserRegistrationException;
import oladejo.mubarak.User.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
        try{
            return ResponseEntity.ok(userService.register(userDto));
        } catch (UserRegistrationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("find/{email}")
    public ResponseEntity<?> findUser(@PathVariable String email){
        try{
            return ResponseEntity.ok(userService.findUserByEmail(email));
        } catch (UserRegistrationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("update/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email ,@RequestBody UserDto userDto){
        try{
            return ResponseEntity.ok(userService.updateUserInfo(email, userDto));
        } catch (UserRegistrationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("delete")
    public ResponseEntity<?> deleteUser(@RequestParam String email){
        try{
            userService.deleteUser(email);
            return ResponseEntity.ok("User deleted successfully");
        } catch (UserRegistrationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
