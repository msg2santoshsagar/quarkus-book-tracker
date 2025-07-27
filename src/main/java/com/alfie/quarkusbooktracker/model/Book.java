package com.alfie.quarkusbooktracker.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "book")
public class Book extends PanacheEntity {

    @NotBlank
    public String title;

    public String author;

    @Enumerated(EnumType.STRING)
    public Status status;

    @Min(1)
    @Max(5)
    public Integer rating;

    @Column(length = 1000)
    public String notes;

    public enum Status {
        READING, COMPLETED, WISHLIST
    }
}
