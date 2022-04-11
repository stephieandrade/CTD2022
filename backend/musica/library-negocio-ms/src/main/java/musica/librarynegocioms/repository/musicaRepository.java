package musica.librarynegocioms.repository;

import musica.librarynegocioms.model.musicaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="musica-service")
public interface musicaRepository {

    @GetMapping("/musica/{id}")
    musicaDTO getMusicaDetails(@PathVariable Integer id);


}
