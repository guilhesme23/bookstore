package tech.gmarques.bookstore_api.author.dto;

import tech.gmarques.bookstore_api.author.Author;

import java.time.LocalDate;

public record AuthorDetailsDTO(
        Long id,
        String name,
        String bio,
        String birthplace,
        LocalDate dob
) {
    public AuthorDetailsDTO(Author author) {
        this(
                author.getId(),
                author.getName(),
                author.getBio(),
                author.getBirthplace(),
                author.getDob()
        );
    }
}
