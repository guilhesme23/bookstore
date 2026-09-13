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

    public BooksController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<BookDetailsDTO> createNewBook(
            @RequestBody @Valid CreateBookDTO data,
            UriComponentsBuilder uriBuilder
    ) {
        log.info("Create new book");
        var book = new Book(data);
        repository.save(book);

        var uriLocation = uriBuilder.path("/books/{id}")
                .buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uriLocation).body(new BookDetailsDTO(book));
    }

    @GetMapping
    public ResponseEntity<List<BookSummaryDTO>> getBooks() {
        var books = repository.findAllByActiveTrue().stream()
                .map(BookSummaryDTO::new).toList();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailsDTO> getBookWithId(@PathVariable Long id) {
        var book = repository.findByIdAndActiveTrue(id);
        return book
                .map(value -> ResponseEntity.ok(new BookDetailsDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteBookWithId(@PathVariable Long id) {
        repository.setBookWithIdInactive(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<BookDetailsDTO> updateBook(@PathVariable Long id, @RequestBody UpdateBookDTO data) {
        var book = repository.findById(id);
        if (book.isEmpty() || !book.get().getActive()) {
            log.debug("Book {} does not exist or is inactive", id);
            return ResponseEntity.notFound().build();
        }

        book.get().update(data);
        return ResponseEntity.ok(new BookDetailsDTO(book.get()));
    }
}
