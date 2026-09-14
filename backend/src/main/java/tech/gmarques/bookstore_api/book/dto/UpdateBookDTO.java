package tech.gmarques.bookstore_api.book.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import tech.gmarques.bookstore_api.book.Language;

import java.util.List;

public record UpdateBookDTO(
        String title,
        String description,
        @JsonAlias("author_id")
        Long authorId,
        List<String> genres,
        String isbn,
        String publisher,
        Language language
) {
}
