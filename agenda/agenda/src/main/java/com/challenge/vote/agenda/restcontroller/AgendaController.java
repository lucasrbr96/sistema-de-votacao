package com.challenge.vote.agenda.restcontroller;

        import com.challenge.vote.agenda.domain.dto.AgendaRequestDTO;
        import com.challenge.vote.agenda.domain.dto.AgendaResponseDTO;
        import com.challenge.vote.agenda.service.AgendaService;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("v1")
public class AgendaController {

        private final AgendaService service;

        public AgendaController(AgendaService service) {
                this.service = service;
        }

        @GetMapping
        public ResponseEntity<List<AgendaResponseDTO>> findAll(){
                return  ResponseEntity.ok(service.findAll());
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<AgendaResponseDTO> findById(@PathVariable Long id){
                return ResponseEntity.ok(service.findById(id));
        }

        @PostMapping
        public ResponseEntity<AgendaResponseDTO> save(@RequestBody AgendaRequestDTO agendaRequestDTO){
                return ResponseEntity.status(HttpStatus.CREATED).body(service.saveOrUpdate(agendaRequestDTO));
        }

        @PutMapping
        public ResponseEntity<AgendaResponseDTO> update(@RequestBody AgendaRequestDTO agendaRequestDTO){
                return ResponseEntity.ok(service.saveOrUpdate(agendaRequestDTO));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id){
                service.deleteById(id);
                return ResponseEntity.noContent().build();
        }

        @GetMapping("/vote")
        public ResponseEntity<List<AgendaResponseDTO>> findToVote(){
                return  ResponseEntity.ok(service.findToVote());
        }

        @GetMapping("/check/{id}")
        public ResponseEntity check(@PathVariable("id") Long id){
                return  ResponseEntity.ok(service.check(id));
        }

        @PutMapping("/result/{id}")
        public ResponseEntity getResultSession(@PathVariable("id") Long id, @RequestBody Boolean result){
                this.service.getResult(id, result);
                return ResponseEntity.status(HttpStatus.OK).build();
        }

}
