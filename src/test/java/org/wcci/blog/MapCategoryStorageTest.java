package org.wcci.blog;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapCategoryStorageTest {
    @Test
    public void shouldBeAbleToStoreCategoryInTheMap(){
        Category testCategory = new Category("horror", "test");
        CategoryStorage underTest = new MapCategoryStorage();
        underTest.store(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);

    }

    @Test
    public void shouldBeAbleToRetrieveSingleCategoryByGenre() {
        Category testCategory1 = new Category("romance", "test");
        Category testCategory2 = new Category("horror", "test");
        CategoryStorage underTest = new MapCategoryStorage();

        underTest.store(testCategory1);
        underTest.store(testCategory2);

        Category retrievedCategory1 = underTest.findCategoryByGenre("romance");
        Category retrievedCategory2 = underTest.findCategoryByGenre("horror");

        assertThat(retrievedCategory1).isEqualTo(testCategory1);
        assertThat(retrievedCategory2).isEqualTo(testCategory2);



    }
}
