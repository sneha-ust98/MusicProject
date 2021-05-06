package com.example.Recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Document(collection = "Recommentation_Record")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Recommendation
{
    //@id annotation makes id variable as primary key
    @Id
    private int id;
    private int counter;
    @NotBlank(message = "Title is Mandatory")
    private String title;
    @NotBlank(message = "Artist is Mandatory")
    private String artist;
    private int releaseyear;
    @NotBlank(message = "Genre is Mandatory")
    private String genre;
}
