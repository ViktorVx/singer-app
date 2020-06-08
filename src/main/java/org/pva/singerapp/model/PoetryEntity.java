package org.pva.singerapp.model;

import java.util.Date;

public class PoetryEntity {

    private String id;

    private String poemName;

    private String author;

    private Date creationDate;

    private String text;

    private String ownerUserId;

    private Boolean isPublic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoemName() {
        return poemName;
    }

    public void setPoemName(String poemName) {
        this.poemName = poemName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public Boolean isPublic() {
        return isPublic;
    }

    public void setPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public String toString() {
        return "PoetryEntity{" +
                "id='" + id + '\'' +
                ", poemName='" + poemName + '\'' +
                ", author='" + author + '\'' +
                ", creationDate=" + creationDate +
                ", text='" + text + '\'' +
                ", ownerUserId='" + ownerUserId + '\'' +
                ", isActive=" + isPublic +
                '}';
    }
}
