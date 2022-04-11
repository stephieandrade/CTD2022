package musica.librarynegocioms.controller;

import musica.librarynegocioms.model.musicaLibrary;
import musica.librarynegocioms.service.LibraryService;
import musica.librarynegocioms.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musica")
public class musicaController {

    private LibraryServiceImpl service;

    @Autowired

    public musicaController(LibraryServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{userTag}")
    public musicaLibrary getMusicDetails(@PathVariable String userTag) {
        return service.getUserLibrary(userTag);
    }

}

