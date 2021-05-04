package com.stackroute.musicservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "music_records")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Music
{
    @Id
    private int id;
    private String title;
    private String artist;
    private int releaseyear;
    private String genre;
}
