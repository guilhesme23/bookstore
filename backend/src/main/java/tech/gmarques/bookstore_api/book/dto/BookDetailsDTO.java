package tech.gmarques.bookstore_api.book.dto;

import tech.gmarques.bookstore_api.book.Book;
import tech.gmarques.bookstore_api.book.Language;
import tech.gmarques.bookstore_api.book.Ratings;

import java.util.List;

public record BookDetailsDTO(
        Long id,
        String title,
        String description,
        BookAuthorSummaryDTO author,
        Ratings rating,
        List<String> genres,
        String isbn,
        String publisher,
        Language language
) {
    public BookDetailsDTO(Book book) {
        this(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                new BookAuthorSummaryDTO(book.getAuthor()),
                book.getRating(),
                book.getGenres(),
                book.getIsbn(),
                book.getPublisher(),
                book.getLanguage()
        );
    }
}
