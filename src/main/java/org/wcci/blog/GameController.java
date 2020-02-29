package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    private GameStorage gameStorage;
    private BlogStorage blogStorage;

    public GameController(GameStorage gameStorage, BlogStorage blogStorage){

        this.gameStorage = gameStorage;
        this.blogStorage = blogStorage;
    }

    @RequestMapping("/games/{title}")
    public String displayGame(@PathVariable String title, Model model) {
        Game retrievedGame = gameStorage.findGameByTitle(title);
        model.addAttribute("game", retrievedGame);
        return "single_game";}

    @PostMapping("/games/{title}/add-blog")
    public String addBlog(@RequestParam String blogTitle, String author, String summary, Model model, @PathVariable String title) {
        Game gameFromBlogTitle = gameStorage.findGameByTitle(blogTitle);
        Blog blogToStore = new Blog(gameFromBlogTitle, author, summary);
        blogStorage.store(blogToStore);
        return "redirect:/games/"+blogTitle;}
}
