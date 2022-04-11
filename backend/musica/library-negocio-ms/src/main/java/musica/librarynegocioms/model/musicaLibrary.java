package musica.librarynegocioms.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class musicaLibrary {
    private String userTag;
    private List<musicaDTO> musicaDTOS;
}
