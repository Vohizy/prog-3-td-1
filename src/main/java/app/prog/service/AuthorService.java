package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.model.CoustomException;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;
    public List<AuthorEntity> getAuthors() {
        return repository.findAll();
    }


    public List<AuthorEntity> createAuthors(List<AuthorEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<AuthorEntity> updateAuthors(List<AuthorEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public AuthorEntity deleteAuthors(int AuthorEntityId) {

        Optional<AuthorEntity> optional = repository.findById(String.valueOf(AuthorEntityId));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {

            throw new CoustomException("BookEntity." + AuthorEntityId + " not found");
        }
    }
}
