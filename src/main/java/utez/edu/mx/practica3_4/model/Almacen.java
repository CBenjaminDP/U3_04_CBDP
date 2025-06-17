package utez.edu.mx.practica3_4.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "almacenes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clave;

    private LocalDate fechaRegistro;

    private Double precioVenta;

    private Double precioRenta;

    @Column(length = 1)
    private String tamaño; // G, M, P

    @ManyToOne
    @JoinColumn(name = "cede_id")
    private Cede cede;

    @PrePersist
    public void generarClave() {
        if (clave == null || clave.isEmpty()) {
            this.clave = cede.getClave() + "-A" + id;
        }
        if (fechaRegistro == null) {
            fechaRegistro = LocalDate.now();
        }
    }
}
