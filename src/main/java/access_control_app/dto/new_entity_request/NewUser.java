package access_control_app.dto.new_entity_request;

import lombok.Data;

@Data
public class NewUser {

    private String nom;
    private String email;
    private String matricule;
    private String idDepartment;

}
