package com.example.Favourites.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.repository.query.Param;

@Document(collection = "Favourites_record")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class Favourites
    {
        @Id
        private int id;
        private String userName;
        private String title;
        private String artist;
        private int releaseyear;
        private String genre;
    }


