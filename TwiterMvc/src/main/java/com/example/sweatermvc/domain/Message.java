package com.example.sweatermvc.domain;

import com.sun.istack.NotNull;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Validated
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @NotBlank(message = "Please fill the message")
    private String text;
    private String tag;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public User getAuthor() {
        return author;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAutthor() {
        return author;
    }

    public void setAutthor(User autthor) {
        this.author = autthor;
    }





    public Message() {

    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";

    }
}