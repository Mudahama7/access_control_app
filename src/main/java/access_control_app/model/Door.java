package access_control_app.model;

import access_control_app.model.enums.StatusDoor;
import access_control_app.model.log.AccessLog;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Door {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StatusDoor status;

    private String location;

    private String secretCodeUnlock = null;

    @ManyToOne
    private AccessZone accessZone;

    @OneToMany(mappedBy = "door")
    private List<AccessLog> accessLogList;

}
