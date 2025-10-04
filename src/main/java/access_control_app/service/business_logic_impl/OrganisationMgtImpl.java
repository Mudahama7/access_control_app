package access_control_app.service.business_logic_impl;

import access_control_app.dto.new_entity_request.NewAdminLocal;
import access_control_app.dto.new_entity_request.NewOrganisation;
import access_control_app.model.Organisation;
import access_control_app.model.User;
import access_control_app.repository.OrganisationRepository;
import access_control_app.service.business_logic.LocalAdminMgt;
import access_control_app.service.business_logic.OrganisationMgt;
import access_control_app.service.mapper.OrganisationMapper;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganisationMgtImpl implements OrganisationMgt {

    private final OrganisationRepository organisationRepository;
    private final OrganisationMapper organisationMapper;
    private final LocalAdminMgt localAdminMgt;

    @Override
    public boolean createOrganisation(NewOrganisation newOrganisation) throws MessagingException {

        Organisation organisation = organisationMapper.mapFromNewOrgReqToEntity(newOrganisation);

        User localAdmin = localAdminMgt.createLocalAdmin(NewAdminLocal.builder()
                        .email(newOrganisation.getEmail())
                        .nomComplete(newOrganisation.getCompleteNomAdminLocal())
                        .nameOrganisation(newOrganisation.getNom())
                .build());

        organisation.setLocalAdmin(localAdmin);
        organisationRepository.save(organisation);
        return true;
    }
}
