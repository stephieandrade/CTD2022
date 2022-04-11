package musica.librarynegocioms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class musicaDTO {

    private Integer id;

    private String nombre;
    private String genero;
    private String artista;
    private String urlStream;
}
