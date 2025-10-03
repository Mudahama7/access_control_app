package access_control_app.model;

import access_control_app.model.enums.Role;
import access_control_app.model.enums.UserAccountStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomComplete;

    private String email;

    private String registrationNumber = null;

    private UserAccountStatus status;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "localAdmin")
    private Organisation organisation;

    @ManyToOne
    private Department department;




}