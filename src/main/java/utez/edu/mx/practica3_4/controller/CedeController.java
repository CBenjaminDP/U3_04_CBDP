package utez.edu.mx.practica3_4.controller;

import utez.edu.mx.practica3_4.model.Cede;
import utez.edu.mx.practica3_4.service.CedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cedes")
@CrossOrigin(origins = "*") // puedes limitar origen si quieres más seguridad
public class CedeController {

    @Autowired
    private CedeService service;

    @GetMapping
    public ResponseEntity<List<Cede>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cede> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cede> create(@RequestBody Cede cede) {
        return ResponseEntity.ok(service.save(cede));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cede> update(@PathVariable Long id, @RequestBody Cede cede) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cede.setId(id);
        return ResponseEntity.ok(service.save(cede));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
