package tech.gmarques.bookstore_api.book.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import tech.gmarques.bookstore_api.book.Language;

import java.util.List;

public record CreateBookDTO(
        @NotBlank(message = "Livro deve conter um título")
        String title,

        @NotBlank(message = "Livro deve conter uma descrição")
        String description,

        @NotNull(message = "Autor não deve ser nulo")
        @JsonAlias("author_id")
        Long authorId,

        List<String> genres,

        @Pattern(regexp = "\\d{13}", message = "ISBN deve conter 13 digitos")
        String isbn,
        String publisher,
        Language language
) {
}
