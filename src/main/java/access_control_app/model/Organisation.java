package access_control_app.model;

import access_control_app.model.enums.OrganisationStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    private String adresse;

    @Enumerated(EnumType.STRING)
    private OrganisationStatus status;

    @OneToOne
    private User localAdmin;

    @OneToMany(mappedBy = "organisation")
    private List<Department> departments;

}
