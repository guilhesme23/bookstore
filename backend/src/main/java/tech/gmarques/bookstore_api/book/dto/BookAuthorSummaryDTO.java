package tech.gmarques.bookstore_api.book.dto;

import tech.gmarques.bookstore_api.author.Author;

public record BookAuthorSummaryDTO(
        Long id,
        String name
) {
    public BookAuthorSummaryDTO(Author author) {
        this(
                author.getId(),
                author.getName()
        );
    }
}
