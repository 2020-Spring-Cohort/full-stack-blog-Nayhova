package org.wcci.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorage categoryStorage;
    private GameStorage gameStorage;
    private BlogStorage blogStorage;



    public Populator(CategoryStorage categoryStorage, GameStorage gameStorage, BlogStorage blogStorage) {
        this.categoryStorage = categoryStorage;
        this.gameStorage = gameStorage;
        this.blogStorage = blogStorage;
    }

    @Override
    public void run(String... args) throws Exception{
    Category dreamcast = new Category("Dreamcast","dreamcast");
    categoryStorage.store(dreamcast);
    Category nintendo = new Category("Nintendo","nintendo");
    categoryStorage.store(nintendo);
    Category superNintendo = new Category("Super Nintendo","super nintendo");
    categoryStorage.store(superNintendo);
    Category xbox = new Category("Xbox", "xbox");
    categoryStorage.store(xbox);
    Category playstation = new Category("Playstation", "playstation");
    categoryStorage.store(playstation);

    Game marioBros = new Game("Mario Brothers", nintendo);
    gameStorage.store(marioBros);
    Game superMario = new Game("Super Mario Brothers", superNintendo);
    gameStorage.store(superMario);
    Game sonicAdventure = new Game("Sonic Adventure", dreamcast);
    gameStorage.store(sonicAdventure);
    Game halo = new Game("Halo", xbox);
    gameStorage.store(halo);
    Game godOfWar = new Game("God of War", playstation);
    gameStorage.store(godOfWar);

    Blog haloReview = new Blog(halo, "Nadir", "Classic game");
    blogStorage.store(haloReview);
    Blog godOfWarReview = new Blog(godOfWar, "Nadir", "Sony backbone");
    blogStorage.store(godOfWarReview);


    }
}
