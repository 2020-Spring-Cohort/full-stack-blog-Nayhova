package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class gameControllerTest {

    private GameController underTest;
    private Model model;
    private GameStorage gameStorage;
    private Game testGame;
    private Category testCategory;

    @Test
    public void shouldBeAbleToDisplayEndPointMovie() {
        Category testCategory = new Category("Comedy", "comedyImage");
        testGame = new Game("Out Cold", testCategory);
        gameStorage = mock(GameStorage.class);
        model = mock(Model.class);
        underTest = new GameController(gameStorage);

        String result = underTest.displayGame("Out Cold", model);
        when(gameStorage.findGameById(1L)).thenReturn(testGame);
        assertThat(result).isEqualTo("single_movie");

    }
    @Test
    public void movieShouldInteractWithDependenciesCorrectly(){
        testCategory = new Category("Comedy", "comedyImage");
        testGame = new Game("Out Cold", testCategory);
        gameStorage = mock(GameStorage.class);
        model = mock(Model.class);
        underTest = new GameController(gameStorage);

        when(gameStorage.findGameByTitle("Out Cold")).thenReturn(testGame);
        underTest.displayGame("Out Cold", model);

        verify(gameStorage).findGameByTitle("Out Cold");
        verify(model).addAttribute("movie", testGame);

    }
    @Test
    public void movieControllerShouldDisplayTheCorrectView() throws Exception{
        testCategory = new Category("Comedy", "comedyImage");
        testGame = new Game("Out Cold", testCategory);
        gameStorage = mock(GameStorage.class);
        model = mock(Model.class);
        underTest = new GameController(gameStorage);

        when(gameStorage.findGameByTitle("Out Cold")).thenReturn(testGame);
        MockMvc mockMVC = MockMvcBuilders.standaloneSetup(underTest).build();

        mockMVC.perform(MockMvcRequestBuilders.get("/games/Out Cold"))
                .andExpect(status().isOk())
                .andExpect(view().name("single_movie"))
                .andExpect(model().attributeExists("movie"))
                .andExpect(model().attribute("movie", testGame));

    }
}
