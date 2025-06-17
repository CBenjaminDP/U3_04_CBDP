package utez.edu.mx.practica3_4.repository;

import utez.edu.mx.practica3_4.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
