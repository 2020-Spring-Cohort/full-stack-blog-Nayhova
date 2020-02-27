package org.wcci.blog;

import java.util.Collection;
import java.util.HashMap;

public class MapCategoryStorage implements CategoryStorage {
    private HashMap<String, Category> categories;

    public MapCategoryStorage(){
        categories = new HashMap<>();
    }


    @Override
    public Collection<Category> findAllCategories() {
        return categories.values();
    }

    @Override
    public void store(Category category) {
        categories.put(category.getGenre(), category);
    }

    @Override
    public Category findCategoryByGenre(String genre) {
        return categories.get(genre);
    }
}
