package musica.librarynegocioms.service;

import musica.librarynegocioms.model.Library;
import musica.librarynegocioms.model.musicaDTO;
import musica.librarynegocioms.model.musicaLibrary;
import musica.librarynegocioms.repository.libraryRepository;
import musica.librarynegocioms.repository.musicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private libraryRepository libraryRepository;
    private musicaRepository feignRepository;

    @Autowired
    public LibraryServiceImpl(musica.librarynegocioms.repository.libraryRepository libraryRepository, musicaRepository feignRepository) {
        this.libraryRepository = libraryRepository;
        this.feignRepository = feignRepository;
    }

    @Override
    public musicaLibrary getUserLibrary(String userTag) {
        // TODO Auto-generated method stub
        List<Library> libraryList = libraryRepository.findAllByUserTag(userTag);
        List<musicaDTO> musicaDTOList = new ArrayList<>();
        for (Library library : libraryList) {
            Integer id = library.getMusicaId();
            musicaDTO musicaDetails = feignRepository.getMusicaDetails(id);
            musicaDTOList.add(musicaDetails);
        }
        return musicaLibrary.builder()
                .userTag(userTag)
                .musicaDTOS(musicaDTOList)
                .build();
    }
    }

