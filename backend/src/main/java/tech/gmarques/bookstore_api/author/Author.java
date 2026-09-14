package tech.gmarques.bookstore_api.author;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import tech.gmarques.bookstore_api.author.dto.CreateAuthorDTO;
import tech.gmarques.bookstore_api.book.Book;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Author")
@Table(name = "authors")
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthplace;
    private LocalDate dob;
    private String bio;
    private Boolean active;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(@Valid CreateAuthorDTO data) {
        BeanUtils.copyProperties(data, this);
        this.active = true;
    }
}


