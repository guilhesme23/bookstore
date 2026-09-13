package tech.gmarques.bookstore_api.book.dto;

import tech.gmarques.bookstore_api.book.Book;

public record BookSummaryDTO(
        Long id,
        String title,
        String description,
        String author,
        Double ratings
) {
    public BookSummaryDTO(Book book) {
        this(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getAuthor(),
                book.getRating().value()
        );
    }
}
