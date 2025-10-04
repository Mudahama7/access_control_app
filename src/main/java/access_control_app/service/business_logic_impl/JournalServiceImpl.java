package access_control_app.service.business_logic_impl;

import access_control_app.dto.LigneJournalAccess;
import access_control_app.repository.AccessLogRepository;
import access_control_app.service.business_logic.JournalService;
import access_control_app.service.mapper.JournalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JournalServiceImpl implements JournalService {

    private final AccessLogRepository accessLogRepository;
    private final JournalMapper journalMapper;

    @Override
    public List<LigneJournalAccess> getJournalAccessByUser() {
        return accessLogRepository.findAll().stream().map(journalMapper::mapFromLogToJournal).toList();
    }
}
