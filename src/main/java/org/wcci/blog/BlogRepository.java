package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface BlogRepository extends CrudRepository<Blog, Long> {
    Collection<Blog> findAllByGame(Game game);


    Blog findBlogByBlogId(Long blogId);
}
