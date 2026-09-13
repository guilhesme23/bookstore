package tech.gmarques.bookstore_api.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Collection<Book> findAllByActiveTrue();

    @Query("""
        update
            Book b
        set b.active = false
        where b.id = :id
    """)
    @Modifying
    @Transactional
    void setBookWithIdInactive(Long id);

    Optional<Book> findByIdAndActiveTrue(Long id);
}
