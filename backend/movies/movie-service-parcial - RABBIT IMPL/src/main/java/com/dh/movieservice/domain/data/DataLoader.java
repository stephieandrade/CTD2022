package com.dh.movieservice.domain.data;

import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final MovieRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Movie(1, "filme", "terror", "what"));
        repository.save(new Movie(2, "borboleta", "terror", "what"));
        repository.save(new Movie(3, "adedonha", "terror", "what"));
        repository.save(new Movie(4, "pajaro", "terror", "what"));
        repository.save(new Movie(5, "dakar", "acción", "what"));
        repository.save(new Movie(6, "shadow", "acción", "what"));
        repository.save(new Movie(7, "boné", "romance", "what"));
        repository.save(new Movie(8, "xícara", "romance", "what"));
    }
}
