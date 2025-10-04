package access_control_app.controller;

import access_control_app.dto.new_entity_request.NewUser;
import access_control_app.service.business_logic.UserService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/users/")
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasAuthority('users-mgt')")
    @PostMapping("create")
    public ResponseEntity<Boolean> createUser(@RequestBody NewUser newUser) throws MessagingException {
        return ResponseEntity.ok().body(userService.createFinalUser(newUser));
    }

}
