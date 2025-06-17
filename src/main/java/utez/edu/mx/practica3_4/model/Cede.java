package utez.edu.mx.practica3_4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "cedes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clave;

    private String estado;

    private String municipio;

    @PrePersist
    public void generateClave() {
        if (clave == null || clave.isEmpty()) {
            String fecha = new SimpleDateFormat("ddMMyyyy").format(new Date());
            int aleatorio = new Random().nextInt(9000) + 1000;
            this.clave = "C" + id + "-" + fecha + "-" + aleatorio;
        }
    }
}