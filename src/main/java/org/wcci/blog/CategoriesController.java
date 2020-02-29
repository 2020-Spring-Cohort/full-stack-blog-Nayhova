package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoriesController {
    private CategoryStorage categoryStorage;
    private GameStorage gameStorage;

    public CategoriesController(CategoryStorage categoryStorage, GameStorage gameStorage) {
        this.categoryStorage = categoryStorage;
        this.gameStorage = gameStorage;
    }


    @RequestMapping({"/categories", "/"})
    public String displayCategories(Model model){
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "index";
    }
    @RequestMapping("/categories/{genre}")
    public String displaySingleCategory(@PathVariable String genre, Model model) {
        Category retrieveCategory = categoryStorage.findCategoryByGenre(genre);
        model.addAttribute("categories", retrieveCategory);
        return "category";}

    @PostMapping("/add-game")
    public String addGame(@RequestParam String gameName, String genre, Model model) {
        Category categoryToStore = categoryStorage.findCategoryByGenre(genre);
        Game gameToStore = new Game(gameName, categoryToStore);
        gameStorage.store(gameToStore);
        model.addAttribute("genre", genre);
        return "redirect:categories/"+ genre;   }
}
