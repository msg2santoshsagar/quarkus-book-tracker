package com.alfie.quarkusbooktracker.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {

    @NotBlank
    private String title;

    private String author;

    private Book.Status status;

    @Min(1)
    @Max(5)
    private Integer rating;

    private String notes;
}
