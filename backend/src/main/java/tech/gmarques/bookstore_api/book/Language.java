package tech.gmarques.bookstore_api.book;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Language {
    private String language;
    private Boolean translation;

    @JsonAlias("original_language")
    private String originalLanguage;
}
