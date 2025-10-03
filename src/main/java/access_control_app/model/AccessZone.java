package access_control_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class AccessZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "accessZone")
    private List<Door> doors;

    @ManyToMany(mappedBy = "accessZoneList")
    private List<User> userList;

}