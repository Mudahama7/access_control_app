package access_control_app.controller;

import access_control_app.dto.new_entity_request.NewOrganisation;
import access_control_app.service.business_logic.OrganisationMgt;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("api/organisation/")
@RestController
public class OrganisationController {

    private final OrganisationMgt organisationMgt;

    @PreAuthorize("hasAuthority('organisation-mgt')")
    @PostMapping("create/")
    private ResponseEntity<Boolean> createOrganisation(@RequestBody NewOrganisation  newOrganisation) throws MessagingException {
        return ResponseEntity.ok().body(organisationMgt.createOrganisation(newOrganisation));
    }



}
