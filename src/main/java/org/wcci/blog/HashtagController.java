package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagController {
    private HashtagRepository hashtagRepository;
    private BlogRepository blogRepository;

    public HashtagController(HashtagRepository hashtagRepository, BlogRepository blogRepository) {
        this.hashtagRepository = hashtagRepository;
        this.blogRepository = blogRepository;
    }
    @RequestMapping({"/hashtags"})
    public String showAllHashtags(Model model){
        model.addAttribute("allHashtags", hashtagRepository.findAll());
        return "all-hashtags";
    }

}
