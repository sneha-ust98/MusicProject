package com.example.Favourites.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotBlank;

@Document(collection = "Favourites_record")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class Favourites
    {
        @Id
        @NotBlank(message = "Id is Mandatory")
        private int id;
        @NotBlank(message = "userName is Mandatory")
        private String userName;
        @NotBlank(message = "Title is Mandatory")
        private String title;
        @NotBlank(message = "Artist is Mandatory")
        private String artist;
        @NotBlank(message = "Release Year is Mandatory")
        private int releaseyear;
        @NotBlank(message = "Genre is Mandatory")
        private String genre;
    }


