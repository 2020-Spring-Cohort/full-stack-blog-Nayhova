package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "genre")
    private Collection<Game> games;

    public Category(){}

    public Category(String genre, String imgUrl) {
        this.genre = genre;
        this.imgUrl = imgUrl;
    }

    private String genre;

    public String imgUrl;

    public String getGenre() {
        return genre;
    }

    public Collection<Game> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (genre != null ? !genre.equals(category.genre) : category.genre != null) return false;
        return imgUrl != null ? imgUrl.equals(category.imgUrl) : category.imgUrl == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Category category = (Category) o;
//
//        if (!id.equals(category.id)) return false;
//        if (!genre.equals(category.genre)) return false;
//        return imgUrl.equals(category.imgUrl);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id.hashCode();
//        result = 31 * result + genre.hashCode();
//        result = 31 * result + imgUrl.hashCode();
//        return result;
//    }
}
