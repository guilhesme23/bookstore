package tech.gmarques.bookstore_api.book.dto;

import tech.gmarques.bookstore_api.book.Language;

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
