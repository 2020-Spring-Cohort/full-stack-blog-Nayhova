package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest {

    private CategoriesController underTest;
    private CategoryStorage mockStorage;

    private MockMvc mockMvc;
    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoriesController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();}

    @Test
    public void shouldFindCategoriesEndPoint() throws Exception {
        when(mockStorage.findAllCategories()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk());}
     @Test
     public void shouldReturnViewWithOneGenre(){
         Category testCategory = new Category("Dreamcast", "testurl");
         when(mockStorage.findCategoryByGenre("Dreamcast")).thenReturn(testCategory);
         underTest.displaySingleCategory("Dreamcast", mockModel);
         verify(mockStorage).findCategoryByGenre("Dreamcast");
         verify(mockModel).addAttribute("categories", testCategory);
     }

}
