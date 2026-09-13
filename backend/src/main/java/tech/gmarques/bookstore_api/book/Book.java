package tech.gmarques.bookstore_api.book;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String author;

    @Embedded
    private Ratings rating;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> genres = new ArrayList<>();
    private String isbn;
    private String publisher;

    @Embedded
    private Language language;

    public Book(@Valid CreateBookDTO data) {
        this.author = data.author();
        this.title = data.title();
        this.description = data.description();
        this.rating = new Ratings(5d, 0, 0);
        if (data.genres() != null) {
            this.genres = data.genres();
        }
        this.isbn = data.isbn();
        this.publisher = data.publisher();
        this.language = data.language();
    }
}
