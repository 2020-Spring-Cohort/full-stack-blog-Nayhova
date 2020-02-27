package org.wcci.blog;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BlogStorageJpaImplTest {

    private BlogRepository underTest;
    private Blog testBlog;
    private Game testGame;
    private Category testCategory;
    private BlogStorageJpaImpl testRepo;

    @Test
    public void shouldFindAllBlogs(){
        underTest = mock(BlogRepository.class);
        testRepo = new BlogStorageJpaImpl(underTest);
        testCategory = new Category("Dreamcast", "test");
        testGame = new Game("Sonic", testCategory);
        testBlog = new Blog(testGame, "Nadir", "good game");

        when(testRepo.findAllBlogs()).thenReturn(Collections.singletonList(testBlog));
        testRepo.store(testBlog);
        verify(underTest).save(testBlog);
        assertThat(testRepo.findAllBlogs()).contains(testBlog);
    }
    @Test
    public void shouldFindBlogsForGame(){
        underTest = mock(BlogRepository.class);
        testRepo = new BlogStorageJpaImpl(underTest);
        testCategory = new Category("Dreamcast", "test");
        testGame = new Game("Sonic", testCategory);
        testBlog = new Blog(testGame, "Nadir", "good game");
        testRepo.store(testBlog);
        when(testRepo.findAllBlogsByGame(testGame)).thenReturn(Collections.singletonList(testBlog));
        verify(underTest).save(testBlog);
        assertThat(testRepo.findAllBlogsByGame(testGame)).contains(testBlog);
    }
}
