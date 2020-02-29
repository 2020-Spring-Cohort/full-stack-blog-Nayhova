package org.wcci.blog;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private Long id;
    private String hashtag;

    @ManyToMany (mappedBy = "hashtags")
    private Collection<Blog> blogs;

    public Hashtag(){}

    public Hashtag(String hashtag){
        blogs = new ArrayList<>();
        this.hashtag = hashtag;
    }

    public Long getId(){return id;}

    public String getHashtag(){return hashtag;}

    public Collection<Blog> getBlogs(){return blogs;}
}
