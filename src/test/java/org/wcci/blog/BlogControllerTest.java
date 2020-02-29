package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BlogControllerTest {
    private MockMvc mockMvc;
    private Model mockModel;

    private BlogController underTest;
    private BlogRepository mockStorage;
    private Game testGame;
    private Blog blogUndertest;
    private HashtagRepository hashTagRepo;

    @BeforeEach
    public void setUp(){
        mockModel = mock(Model.class);
        mockStorage = mock(BlogRepository.class);
        underTest = new BlogController(mockStorage, hashTagRepo);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        Category fakeCategory = new Category("Dreamcast", "image");
        testGame = new Game("Sonic", fakeCategory);
        blogUndertest = new Blog(testGame, "Nadir", "good game");
    }
    @Test
    public void shouldFindBlogEndpoint(){
        when(mockStorage.findById(1L)).thenReturn(Optional.of(blogUndertest));
        String result = underTest.displayBlog(1L, mockModel);
        assertThat(result).isEqualTo("single_blog");
    }
    @Test
    public void shouldBeAbletoRetrieveSingleReview(){
        when(mockStorage.findById(1L)).thenReturn(Optional.of(blogUndertest));
        underTest.displayBlog(1L, mockModel);
        verify(mockStorage).findById(1L);
        verify(mockModel).addAttribute("blog", blogUndertest);
    }
    @Test
    public void displayBlogMappingIsCorrect() throws Exception{
        when(mockStorage.findById(1L)).thenReturn(Optional.of(blogUndertest));
        mockMvc.perform(MockMvcRequestBuilders.get("/blogs/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("single_blog"))
                .andExpect(model().attributeExists("blog"))
                .andExpect(model().attribute("blog", blogUndertest));
    }
}
