package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BlogStorageJpaImpl implements BlogStorage{
    private BlogRepository blogRepository;
    public BlogStorageJpaImpl(BlogRepository blogRepository){this.blogRepository = blogRepository;}

    @Override
    public Collection<Blog> findAllBlogs() {
        return (Collection<Blog>) blogRepository.findAll();
    }

    @Override
    public void store(Blog blog) {blogRepository.save(blog);

    }
    public Collection<Blog> findAllBlogsByGame(Game game){
        return (Collection<Blog>) blogRepository.findAllByGame(game);
    }
}
