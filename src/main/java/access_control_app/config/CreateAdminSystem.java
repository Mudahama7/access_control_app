package access_control_app.config;

import access_control_app.model.User;
import access_control_app.model.enums.Role;
import access_control_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
public class CreateAdminSystem {

    private final access_control_app.service.utils.EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                User user = new User();
                user.setEmail("isharamudahama7@gmail.com");
                user.setNomComplete("Admin");
                user.setPassword(passwordEncoder.encode("admin1234"));
                user.setRole(Role.ADMINISTRATOR_SYSTEM);

                userRepository.save(user);

                emailService.sendEmail(
                        user.getEmail(),
                        "Compte admin crée avec succès, votre mot de passe est : admin1234",
                        "Création compte Administrator"
                );
            }
        };
    }
}
