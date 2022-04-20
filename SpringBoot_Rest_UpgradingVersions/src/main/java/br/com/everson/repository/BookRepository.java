package br.com.everson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everson.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}