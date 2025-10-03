package access_control_app.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    private String adresse;

    private boolean status;

    @OneToOne
    private User localAdmin;

    @OneToMany(mappedBy = "organisation")
    private List<Department> departments;

}
