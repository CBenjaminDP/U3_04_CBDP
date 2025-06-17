package utez.edu.mx.practica3_4.controller;

import utez.edu.mx.practica3_4.model.Almacen;
import utez.edu.mx.practica3_4.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
@CrossOrigin(origins = "*")
public class AlmacenController {

    @Autowired
    private AlmacenService service;

    @GetMapping
    public ResponseEntity<List<Almacen>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Almacen> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Almacen> create(@RequestBody Almacen almacen) {
        return ResponseEntity.ok(service.save(almacen));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Almacen> update(@PathVariable Long id, @RequestBody Almacen almacen) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        almacen.setId(id);
        return ResponseEntity.ok(service.save(almacen));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
