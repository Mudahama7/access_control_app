package access_control_app.service.business_logic_impl;

import access_control_app.dto.new_entity_request.NewAdminLocal;
import access_control_app.model.User;
import access_control_app.service.business_logic.LocalAdminMgt;
import access_control_app.service.business_logic.UserService;
import access_control_app.service.mapper.LocalAdminMapper;
import access_control_app.service.utils.EmailService;
import access_control_app.service.utils.PasswordGenerator;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class LocalAdminMgtImpl implements LocalAdminMgt {

    private final UserService userService;
    private final LocalAdminMapper localAdminMapper;
    private final EmailService emailService;
    private final PasswordGenerator passwordGenerator;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createLocalAdmin(NewAdminLocal newAdminLocal) throws MessagingException {

        User localAdmin = localAdminMapper.mapFromAdminReqToEntity(newAdminLocal);
        String password = passwordGenerator.generate();

        localAdmin.setPassword(passwordEncoder.encode(password));
        String mailText = String.format(
                """
                    Bonjour !
                
                    Une Organisation du nom de %s vient d'etre créée dans notre système de gestion d'accès physique et logique
                    Et vous avez été désigné comme administrateur local dans notre systeme, de la dite organisation, ainsi nous vous partageons
                    vos informations de connexion pour pouvoir vous connecter et ainsi configurer et suivre votre espace de travail
                
                    email : %s
                
                    mot de passe : %s
                """,
                newAdminLocal.getNameOrganisation(),
                newAdminLocal.getEmail(),
                password);

        localAdmin = userService.saveUser(localAdmin);

        emailService.sendEmail(newAdminLocal.getEmail(), mailText, "Confirmation de Création d'Organisation");

        return localAdmin;

    }



}
