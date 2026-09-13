package tech.gmarques.bookstore_api.book;

import java.util.List;

public record UpdateBookDTO(
        String title,
        String description,
        String author,
        List<String> genres,
        String isbn,
        String publisher,
        Language language
) {
}
