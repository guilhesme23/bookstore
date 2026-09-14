package tech.gmarques.bookstore_api.author.dto;

import tech.gmarques.bookstore_api.author.Author;

import java.time.LocalDate;
import java.util.List;

public record AuthorDetailsDTO(
        Long id,
        String name,
        String bio,
        String birthplace,
        LocalDate dob,
        List<AuthorBooksSummaryDTO> books
) {
    public AuthorDetailsDTO(Author author) {
        this(
                author.getId(),
                author.getName(),
                author.getBio(),
                author.getBirthplace(),
                author.getDob(),
                author.getBooks().stream().map(AuthorBooksSummaryDTO::new).toList()
        );
    }
}
