package access_control_app.model;

import access_control_app.model.enums.Role;
import access_control_app.model.enums.UserAccountStatus;
import access_control_app.model.log.AccessLog;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomComplete;

    private String email;

    private String registrationNumber = null;

    private UserAccountStatus status = UserAccountStatus.ACTIVE;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "localAdmin")
    private Organisation organisation;

    @ManyToOne
    private Department department = null;

    @OneToOne(mappedBy = "user")
    private RFIDCard rfidCard;

    @ManyToMany
    @JoinTable(
            name = "users_zones",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "zone_id")
    )
    private List<AccessZone> accessZoneList;

    @OneToMany(mappedBy = "user")
    private List<AccessLog> accessLogList;

}