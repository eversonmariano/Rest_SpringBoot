package br.com.everson.services;


import br.com.everson.converter.DozerConverter;
import br.com.everson.data.model.Book;
import br.com.everson.data.vo.v1.BookVO;
import br.com.everson.exception.ResourceNotFoundException;
import br.com.everson.request.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {


    @Autowired
    BookRepository repository;

    public BookVO create(BookVO book) {
        var entity = DozerConverter.parserObject(book, Book.class);
        var vo = DozerConverter.parserObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public List<BookVO> findAll() {
        return DozerConverter.parserListObjects(repository.findAll(), BookVO.class);
    }

    public BookVO findById(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parserObject(entity, BookVO.class);
    }

    public BookVO update(BookVO book) {
        var entity = repository.findById(book.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var vo = DozerConverter.parserObject(repository.save(entity), BookVO.class);
        return vo;
    }

    public void delete(Long id) {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}