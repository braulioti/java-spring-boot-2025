package br.com.braulioti.repositoriy;

import br.com.braulioti.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }
