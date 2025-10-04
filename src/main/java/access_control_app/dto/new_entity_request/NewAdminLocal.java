package access_control_app.dto.new_entity_request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewAdminLocal {

    private String nomComplete;
    private String email;
    private String nameOrganisation;

}
