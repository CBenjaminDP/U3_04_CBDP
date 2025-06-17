package utez.edu.mx.practica3_4.service;

import utez.edu.mx.practica3_4.model.Cede;
import utez.edu.mx.practica3_4.repository.CedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CedeService {

    @Autowired
    private CedeRepository repository;

    public List<Cede> findAll() {
        return repository.findAll();
    }

    public Optional<Cede> findById(Long id) {
        return repository.findById(id);
    }

    public Cede save(Cede cede) {
        return repository.save(cede);
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
