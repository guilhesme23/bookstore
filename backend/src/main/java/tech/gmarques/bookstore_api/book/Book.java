package tech.gmarques.bookstore_api.book;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.beans.BeanUtils;
import tech.gmarques.bookstore_api.author.Author;
import tech.gmarques.bookstore_api.book.dto.CreateBookDTO;
import tech.gmarques.bookstore_api.book.dto.UpdateBookDTO;
import tech.gmarques.bookstore_api.util.ModelUtils;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Book")
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

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Embedded
    private Ratings rating;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> genres = new ArrayList<>();
    private String isbn;
    private String publisher;

    @Embedded
    private Language language;

    private Boolean active;

    public Book(@Valid CreateBookDTO data, Author author) {
        this.author = author;
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

    public void update(UpdateBookDTO data, Author author) {
        String[] nullProperties = ModelUtils.getNullProperties(data);
        BeanUtils.copyProperties(data, this, nullProperties);

        if (author != null) {
            this.author = author;
        }
    }
}
