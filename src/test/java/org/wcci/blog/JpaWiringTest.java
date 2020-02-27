package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private GameRepository gameRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void categoryShouldHaveAListOfMovies() {
        Category testCategory = new Category("comedy","comedy");
        Game testMovie = new Game("Out Cold", testCategory);

        categoryRepo.save(testCategory);
        gameRepo.save(testMovie);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOptional = categoryRepo
                .findByGenre(testCategory.getGenre());

        Category retrievedCategory = retrievedCategoryOptional.get();
        Game retrievedMovie = gameRepo.findById(testMovie.getId()).get();

        assertThat(retrievedCategory.getMovies()).contains(testMovie);

    }
}
