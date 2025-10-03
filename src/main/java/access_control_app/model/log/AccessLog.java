package access_control_app.model.log;

import access_control_app.model.Door;
import access_control_app.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    private boolean accessGranted;

    @ManyToOne
    private User user;

    @ManyToOne
    private Door door;

}
