package access_control_app.service.business_logic;

import access_control_app.dto.new_entity_request.NewAdminLocal;
import access_control_app.model.User;
import jakarta.mail.MessagingException;

public interface LocalAdminMgt {

    User createLocalAdmin(NewAdminLocal newAdminLocal) throws MessagingException;

}
