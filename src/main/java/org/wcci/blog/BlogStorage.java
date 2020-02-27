package org.wcci.blog;

import java.util.Collection;

public interface BlogStorage {
    Collection<Blog> findAllBlogs();

    void store(Blog blog);
}
