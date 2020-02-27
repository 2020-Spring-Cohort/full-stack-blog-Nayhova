package org.wcci.blog;

public interface GameStorage {

    void store(Game gameToStore);

    Game findGameById(Long id);

    Game findGameByTitle(String title);

}
