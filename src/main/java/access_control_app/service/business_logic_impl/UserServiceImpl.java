package access_control_app.service.business_logic_impl;

import access_control_app.dto.new_entity_request.NewUser;
import access_control_app.exception.type_exception.UserNotFoundException;
import access_control_app.model.User;
import access_control_app.repository.UserRepository;
import access_control_app.service.business_logic.UserService;
import access_control_app.service.mapper.UserMapper;
import access_control_app.service.utils.EmailService;
import access_control_app.service.utils.PasswordGenerator;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordGenerator passwordGenerator;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public User getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    @Override
    public boolean createFinalUser(NewUser newUser) throws MessagingException {
        User user = userMapper.mapFromDtoReqToEntity(newUser);
        String password = passwordGenerator.generate();
        user.setPassword(passwordEncoder.encode(password));
        String mailText = String.format("""
                Bonjour cher %s
                Nous tenions à vous notifier qu'un compte d'accès au systeme de l'entreprise vient d'etre crée pour vous.
                Veuillez vous connectez pour plus de details, surtout voir vos zones d'accès !
                Vos identifiants sont : 
                email : %s
                password : %s
                Ces informations sont confidentielles ! Ne les partagez avec personne !
                """,
                newUser.getNom(),
                newUser.getEmail(),
                password
        );
        emailService.sendEmail(newUser.getEmail(), mailText, "Notification du Systeme");
        return true;
    }

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);

    }

}