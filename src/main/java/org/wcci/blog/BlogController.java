package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
    private BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    @RequestMapping("/blogs/{blogId}")
    public String displayBlog(@PathVariable long blogId, Model model) {
        Blog retrievedBlog = blogRepository.findById(blogId).get();
        model.addAttribute("blog", retrievedBlog);
        return "single_game";
    }

    @RequestMapping("/blogs")
    public String displayBlog(Model model) {
        model.addAttribute("blog", blogRepository.findAll());
        return "blogs_multiple";}
}
