package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {
    private BlogRepository blogRepository;
    private HashtagRepository hashTagRepo;

    public BlogController(BlogRepository blogRepository, HashtagRepository hashTagRepo){
        this.blogRepository = blogRepository;
        this.hashTagRepo = hashTagRepo;
    }
    @RequestMapping("/blogs/{blogId}")
    public String displayBlog(@PathVariable long blogId, Model model) {
        Blog retrievedBlog = blogRepository.findById(blogId).get();
        model.addAttribute("blog", retrievedBlog);
        return "single_blog";
    }

    @RequestMapping("/blogs")
    public String displayBlog(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        return "blogs_multiple";}

    @PostMapping("/blogs/{blogId}/add-hashtag")
    public String addHashtagToBlog(@RequestParam String hashTag, @PathVariable Long blogId){
        Hashtag hashTagToAddToBlog;
        Optional<Hashtag> hashTagToAddOpt = hashTagRepo.findHashtagByHashtag(hashTag);
        if(hashTagToAddOpt.isEmpty()){
            hashTagToAddToBlog = new Hashtag(hashTag);
            hashTagRepo.save(hashTagToAddToBlog);
        }else{
            hashTagToAddToBlog = hashTagToAddOpt.get();
        }
        Blog reviewToAddHashtagTo = blogRepository.findBlogByBlogId(blogId);
        reviewToAddHashtagTo.addHashtag(hashTagToAddToBlog);
        blogRepository.save(reviewToAddHashtagTo);
        return "redirect:/blogs/"+ blogId;
    }
}
