package access_control_app.dto.new_entity_request;

import lombok.Data;

@Data
public class NewOrganisation {

    private String nom;
    private String adresse;

    private String CompleteNomAdminLocal;
    private String email;

}
