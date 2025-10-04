package access_control_app.service.business_logic;

import access_control_app.dto.new_entity_request.NewOrganisation;
import jakarta.mail.MessagingException;

public interface OrganisationMgt {


    boolean createOrganisation(NewOrganisation newOrganisation) throws MessagingException;


}
