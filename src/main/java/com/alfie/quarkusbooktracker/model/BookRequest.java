package com.alfie.quarkusbooktracker.model;

import jakarta.validation.constraints.*;

public class BookRequest {

    @NotBlank
    public String title;

    public String author;

    public Book.Status status;

    @Min(1)
    @Max(5)
    public Integer rating;

    public String notes;
}
