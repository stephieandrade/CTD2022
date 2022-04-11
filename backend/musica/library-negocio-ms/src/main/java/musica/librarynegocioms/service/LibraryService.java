package musica.librarynegocioms.service;

import musica.librarynegocioms.model.musicaLibrary;

public interface LibraryService {
    musicaLibrary getUserLibrary(String userTag);
}
