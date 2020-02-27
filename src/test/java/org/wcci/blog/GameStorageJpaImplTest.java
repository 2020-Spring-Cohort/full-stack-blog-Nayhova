package org.wcci.blog;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GameStorageJpaImplTest {

    private GameRepository gameRepository;
    private GameStorage underTest;
    private Game halo;

    @Test
    public void shouldFindGameeById(){
        gameRepository = mock(GameRepository.class);
        underTest = new GameStorageJpaImpl(gameRepository);
        Category testCategory = new Category("Comedy", "comedyPic");
        halo = new Game("Out Cold", testCategory);

        when(gameRepository.findById(1L)).thenReturn(Optional.of(halo));
        Game retrievedMovie = underTest.findGameById(1L);

        assertThat(retrievedMovie).isEqualTo(halo);

    }

    @Test
    public void shouldStoreGame(){
        gameRepository = mock(GameRepository.class);
        underTest = new GameStorageJpaImpl(gameRepository);
        Category testCategory = new Category("Comedy", "comedyPic");
        halo = new Game("Out Cold", testCategory);

        underTest.store(halo);
        verify(gameRepository).save(halo);
    }
}
