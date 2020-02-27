package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Blog {

    public Blog(){}

    public Game getGame() {
        return game;
    }

    public String getAuthor() {
        return author;
    }

    public Long getBlogId() {
        return blogId;
    }

    public String getGameTitleFromReview(){
        return game.getTitle();
    }

    @ManyToOne
    private Game game;

    private String author;

    private String comments;

    @Id
    @GeneratedValue
    private Long blogId;

    public Blog(Game game, String author, String comments) {
        this.author = author;
        this.game = game;
        this.comments = comments;
    }
    public String getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Blog blog = (Blog) o;

        if (game != null ? !game.equals(blog.game) : blog.game != null) return false;
        if (author != null ? !author.equals(blog.author) : blog.author != null) return false;
        if (comments != null ? !comments.equals(blog.comments) : blog.comments != null) return false;
        return blogId != null ? blogId.equals(blog.blogId) : blog.blogId == null;
    }

    @Override
    public int hashCode() {
        int result = game != null ? game.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (blogId != null ? blogId.hashCode() : 0);
        return result;
    }
}
