package com.example.movieAPI.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue
    @Column(updatable=false, nullable = false)
    Integer Id;
    @Column
    String Title;
    @Column
    String Description;
    @Column
    Category Category;
    @Column(updatable = false)
    Integer ReleaseDate;

    @ManyToOne
    @JoinColumn(name="StudioId")
    Studio Studio;
}
