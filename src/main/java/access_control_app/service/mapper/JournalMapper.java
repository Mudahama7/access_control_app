package access_control_app.service.mapper;

import access_control_app.dto.LigneJournalAccess;
import access_control_app.model.log.AccessLog;
import org.springframework.stereotype.Service;

@Service
public class JournalMapper {

    public LigneJournalAccess mapFromLogToJournal(AccessLog accessLog) {
        return LigneJournalAccess.builder()
                .accessZoneName(accessLog.getDoor().getAccessZone().getName())
                .accessDate(accessLog.getTimestamp())
                .locationDoor(accessLog.getDoor().getLocation())
                .nomUser(accessLog.getUser().getNomComplete())
                .uidRFIDCard(accessLog.getUser().getRfidCard().getUid())
                .nameDoor(accessLog.getDoor().getName())
                .build();
    }

}
