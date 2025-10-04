package access_control_app.controller;

import access_control_app.dto.LigneJournalAccess;
import access_control_app.service.business_logic.JournalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("api/journal/")
@RestController
public class JournalController {


    private final JournalService journalService;

    @GetMapping("getAll")
    public ResponseEntity<List<LigneJournalAccess>> getJournalAccess() {
        return ResponseEntity.ok().body(journalService.getJournalAccessByUser());
    }


}
