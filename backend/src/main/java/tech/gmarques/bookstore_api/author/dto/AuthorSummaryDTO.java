package tech.gmarques.bookstore_api.author.dto;

import tech.gmarques.bookstore_api.author.Author;

public record AuthorSummaryDTO(
        Long id,
        String name,
        String bio
) {
    public AuthorSummaryDTO(Author author) {
        this(
                author.getId(),
                author.getName(),
                author.getBio()
        );
    }
}
