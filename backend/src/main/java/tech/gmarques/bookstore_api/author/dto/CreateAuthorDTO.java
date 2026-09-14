package tech.gmarques.bookstore_api.author.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record CreateAuthorDTO(
        @NotBlank
        String name,
        String birthplace,
        @DateTimeFormat
        LocalDate dob,
        String bio
) {
}
