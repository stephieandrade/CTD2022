package musica.librarynegocioms.repository;

import musica.librarynegocioms.model.Library;
import musica.librarynegocioms.model.musicaLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface libraryRepository extends JpaRepository<Library, Integer> {
    public List<Library> findAllByUserTag(String userTag);

}
