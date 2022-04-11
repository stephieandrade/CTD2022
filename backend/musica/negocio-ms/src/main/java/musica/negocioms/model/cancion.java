package musica.negocioms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cancion")
@NoArgsConstructor
@AllArgsConstructor
public class cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String genero;
    private String artista;
    private String urlStream;

}
