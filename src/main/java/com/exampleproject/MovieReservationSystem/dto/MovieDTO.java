package com.exampleproject.MovieReservationSystem.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    @NotBlank(message = "The title cannot be blank")
    private String title;
    @NotBlank(message = "The genre cannot be blank")
    private String genre;
    @Min(value = 1, message = "The duration must be greater than 1 minute")
    @Max(value = 300,message = "The duration must be less than 300 minutes")
    private int duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}
