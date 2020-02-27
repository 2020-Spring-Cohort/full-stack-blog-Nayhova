package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class GameStorageJpaImpl implements GameStorage {

    private final GameRepository gameRepository;

    public GameStorageJpaImpl(GameRepository gameRepo) {this.gameRepository = gameRepo;}

    @Override
    public void store(Game gameToStore) {
        gameRepository.save(gameToStore);
    }

    @Override
    public  Game findGameById(Long id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public Game findGameByTitle(String title) {
        return gameRepository.findGameByTitle(title);
    }
}
