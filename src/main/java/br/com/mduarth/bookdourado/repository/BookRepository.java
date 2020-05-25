package br.com.mduarth.bookdourado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mduarth.bookdourado.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
