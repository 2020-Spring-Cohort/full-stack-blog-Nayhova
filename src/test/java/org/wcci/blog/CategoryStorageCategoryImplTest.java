package org.wcci.blog;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStorageCategoryImplTest {

    @Test
    public void shouldFindAllCategories(){
        CategoryRepository mockCatRepo = mock(CategoryRepository.class);
        Category catUnderTest = new Category("testGenre", "testUrl");
        CategoryStorage catStorageUnderTest = new CategoryStorageCategoryImpl(mockCatRepo);

        when(mockCatRepo.findAll()).thenReturn(Collections.singletonList(catUnderTest));
        catStorageUnderTest.store(catUnderTest);
        verify(mockCatRepo).save(catUnderTest);
        assertThat(catStorageUnderTest.findAllCategories()).contains(catUnderTest);}

     @Test
     public void shouldRetrieveSingleCategoryByGenre(){
         CategoryRepository mockCatRepo = mock(CategoryRepository.class);

         Category catUnderTest1 = new Category("testGenre1", "testUrl1");
         Category catUnderTest2 = new Category("testGenre2", "testUrl2");
         CategoryStorage catStorageUnderTest = new CategoryStorageCategoryImpl(mockCatRepo);

         catStorageUnderTest.store(catUnderTest1);
         catStorageUnderTest.store(catUnderTest2);

         Optional<Category> testCategory1Optional = Optional.of(catUnderTest1);
         when(mockCatRepo.findByGenre("testGenre1")).thenReturn(testCategory1Optional);

         Optional<Category> testCategory2Optional = Optional.of(catUnderTest2);
         when(mockCatRepo.findByGenre("testGenre2")).thenReturn(testCategory2Optional);

         Category retrievedCategory1 = catStorageUnderTest.findCategoryByGenre("testGenre1");
         Category retrievedCategory2 =  catStorageUnderTest.findCategoryByGenre("testGenre2");
         assertThat(retrievedCategory1).isEqualTo(catUnderTest1);
         assertThat(retrievedCategory2).isEqualTo(catUnderTest2);

     }
}


