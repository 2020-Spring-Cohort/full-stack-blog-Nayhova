package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Game {
    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne
    private Category genre;
    public String title;

    public Game(){}

    public Game(String title, Category genre) {
        this.title = title;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", genre=" + genre +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (id != null ? !id.equals(game.id) : game.id != null) return false;
        if (genre != null ? !genre.equals(game.genre) : game.genre != null) return false;
        return title != null ? title.equals(game.title) : game.title == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Game game = (Game) o;
//
//        if (!id.equals(game.id)) return false;
//        if (!genre.equals(game.genre)) return false;
//        return title.equals(game.title);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id.hashCode();
//        result = 31 * result + genre.hashCode();
//        result = 31 * result + title.hashCode();
//        return result;
//    }
}
