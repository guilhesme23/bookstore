package tech.gmarques.bookstore_api.book;

import java.util.List;

public record BookDetailsDTO(
        Long id,
        String title,
        String description,
        String author,
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
                book.getAuthor(),
                book.getRating(),
                book.getGenres(),
                book.getIsbn(),
                book.getPublisher(),
                book.getLanguage()
        );
    }
}
