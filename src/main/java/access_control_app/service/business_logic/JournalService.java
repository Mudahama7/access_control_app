package access_control_app.service.business_logic;

import access_control_app.dto.LigneJournalAccess;

import java.util.List;

public interface JournalService {

    List<LigneJournalAccess> getJournalAccessByUser();

}
