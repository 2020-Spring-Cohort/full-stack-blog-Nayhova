package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {
    private GameStorage gameStorage;

    public GameController(GameStorage gameStorage){
        this.gameStorage = gameStorage;
    }

    @RequestMapping("/games/{title}")
    public String displayGame(@PathVariable String title, Model model) {
        Game retrievedMovie = gameStorage.findGameByTitle(title);
        model.addAttribute("movie", retrievedMovie);
        return "single_movie";}
}
