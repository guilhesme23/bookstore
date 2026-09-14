package tech.gmarques.bookstore_api.author.dto;

import tech.gmarques.bookstore_api.book.Book;

public record AuthorBooksSummaryDTO(
        Long id,
        String title
) {
    public AuthorBooksSummaryDTO(Book book) {
        this(
                book.getId(),
                book.getTitle()
        );
    }
}
