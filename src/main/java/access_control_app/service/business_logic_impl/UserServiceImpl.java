package access_control_app.service.business_logic_impl;

import access_control_app.exception.type_exception.UserNotFoundException;
import access_control_app.model.User;
import access_control_app.repository.UserRepository;
import access_control_app.service.business_logic.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);

    }

}