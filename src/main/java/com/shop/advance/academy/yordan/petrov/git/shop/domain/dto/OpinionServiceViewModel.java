package com.shop.advance.academy.yordan.petrov.git.shop.domain.dto;


import com.shop.advance.academy.yordan.petrov.git.shop.data.models.enums.Rating;

import java.util.Objects;
import java.util.Set;

public class OpinionServiceViewModel {
    private Long id;
    private String comment;
    private Rating rating = Rating.NONE;
    private Double vote;
    private Set<MediaServiceModel> media;
    private UserServiceViewModel user;

    public OpinionServiceViewModel() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Rating getRating() {
        return this.rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Double getVote() {
        return this.vote;
    }

    public void setVote(Double vote) {
        this.vote = vote;
    }

    public Set<MediaServiceModel> getMedia() {
        return this.media;
    }

    public void setMedia(Set<MediaServiceModel> media) {
        this.media = media;
    }

    public UserServiceViewModel getUser() {
        return this.user;
    }

    public void setUser(UserServiceViewModel user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpinionServiceViewModel)) return false;
        OpinionServiceViewModel that = (OpinionServiceViewModel) o;
        return Objects.equals(comment, that.comment) &&
                rating == that.rating &&
                Objects.equals(vote, that.vote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, rating, vote);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpinionServiceViewModel{");
        sb.append("comment='").append(comment).append('\'');
        sb.append(", rating=").append(rating);
        sb.append(", vote=").append(vote);
        sb.append('}');
        return sb.toString();
    }
}
