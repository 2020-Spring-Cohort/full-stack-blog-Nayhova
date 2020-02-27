package org.wcci.blog;

import java.util.Collection;

public interface CategoryStorage {
    Collection<Category> findAllCategories();

    void store(Category category);

    Category findCategoryByGenre(String genre);
}
