package utez.edu.mx.practica3_4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombreCompleto;

    @NotBlank
    @Size(min = 10, max = 15)
    private String telefono;

    @NotBlank
    @Email
    private String correo;
}
