package tech.gmarques.bookstore_api.book;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Ratings(
        @Column(name = "rating")
        Double value,
        @JsonAlias("num_ratings")
        Integer numRatings,
        @JsonAlias("total_sum_ratings")
        Integer totalSumRatings
) {
}
