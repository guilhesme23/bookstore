package tech.gmarques.bookstore_api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.gmarques.bookstore_api.author.Author;
import tech.gmarques.bookstore_api.author.AuthorRepository;
import tech.gmarques.bookstore_api.author.dto.AuthorDetailsDTO;
import tech.gmarques.bookstore_api.author.dto.AuthorSummaryDTO;
import tech.gmarques.bookstore_api.author.dto.CreateAuthorDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository repository;

    AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorDetailsDTO> createAuthor(@RequestBody @Valid CreateAuthorDTO data, UriComponentsBuilder uriBuilder) {
        var author = new Author(data);
        repository.save(author);
        var location = uriBuilder.path("/authors/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(location).body(new AuthorDetailsDTO(author));
    }

    @GetMapping
    public ResponseEntity<List<AuthorSummaryDTO>> getAuthors() {
        var authors = repository.findAll().stream()
                .map(AuthorSummaryDTO::new)
                .toList();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDetailsDTO> getAuthor(@PathVariable Long id) {
        return repository.findById(id)
                .map(a -> ResponseEntity.ok(new AuthorDetailsDTO(a)))
                .orElse(ResponseEntity.notFound().build());
    }
}
