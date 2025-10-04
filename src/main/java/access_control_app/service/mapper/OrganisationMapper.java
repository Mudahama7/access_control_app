package access_control_app.service.mapper;

import access_control_app.dto.new_entity_request.NewOrganisation;
import access_control_app.model.Organisation;
import access_control_app.model.enums.OrganisationStatus;
import org.springframework.stereotype.Service;

@Service
public class OrganisationMapper {


    public Organisation mapFromNewOrgReqToEntity(NewOrganisation newOrganisation) {
        Organisation organisation = new Organisation();

        organisation.setNom(newOrganisation.getNom());
        organisation.setAdresse(newOrganisation.getAdresse());
        organisation.setStatus(OrganisationStatus.ACTIVE);

        return organisation;
    }


}