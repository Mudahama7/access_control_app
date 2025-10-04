package access_control_app.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LigneJournalAccess {

    private String nomUser;
    private LocalDateTime accessDate;
    private String nameDoor;
    private String locationDoor;
    private String accessZoneName;
    private String uidRFIDCard;

}
