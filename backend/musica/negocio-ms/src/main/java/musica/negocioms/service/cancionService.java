package musica.negocioms.service;

import musica.negocioms.model.cancion;
import musica.negocioms.repository.cancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cancionService implements cancionIService {

    @Override
    public cancion getCancion(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Autowired
    public cancionRepository repository;


}
