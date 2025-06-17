package utez.edu.mx.practica3_4.service;

import utez.edu.mx.practica3_4.model.Almacen;
import utez.edu.mx.practica3_4.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {

    @Autowired
    private AlmacenRepository repository;

    public List<Almacen> findAll() {
        return repository.findAll();
    }

    public Optional<Almacen> findById(Long id) {
        return repository.findById(id);
    }

    public Almacen save(Almacen almacen) {
        return repository.save(almacen);
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
