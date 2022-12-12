package app.prog.repository;

import app.prog.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface BookRepository extends JpaRepository<Book, String> {
=======
public interface BookRepository extends JpaRepository<BookEntity, String> {
>>>>>>> dev
}
