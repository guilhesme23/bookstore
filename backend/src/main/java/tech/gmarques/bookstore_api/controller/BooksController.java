package tech.gmarques.bookstore_api.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.gmarques.bookstore_api.book.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final Logger log = LoggerFactory.getLogger(BooksController.class);

    private final BookRepository repository;

    public BooksController(BookRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<BookDetailsDTO> createNewBook(
            @RequestBody @Valid CreateBookDTO data,
            UriComponentsBuilder uriBuilder
    ) {
        log.info("Create new book");
        var uriLocation = uriBuilder.path("").buildAndExpand().toUri();

        var book = new Book(data);
        repository.save(book);

        return ResponseEntity.created(uriLocation).body(new BookDetailsDTO(book));
    }

    @GetMapping
    public ResponseEntity<List<BookSummaryDTO>> getBooks() {
        var books = repository.findAll().stream()
                .map(BookSummaryDTO::new).toList();

        return ResponseEntity.ok(books);
    }
}
