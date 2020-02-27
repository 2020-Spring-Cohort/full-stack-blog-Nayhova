package org.wcci.blog;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryStorageCategoryImpl implements CategoryStorage {

    private CategoryRepository categoryRepository;

    public CategoryStorageCategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;}
    @Override
    public Collection<Category> findAllCategories() {
        return (Collection <Category>) categoryRepository.findAll();
    }

    @Override
    public void store(Category category) {categoryRepository.save(category);

    }

    @Override
    public Category findCategoryByGenre(String genre) {
        return categoryRepository.findByGenre(genre).get();
    }
}
