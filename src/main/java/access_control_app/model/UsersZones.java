package access_control_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UsersZones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private AccessZone accessZone;

}
