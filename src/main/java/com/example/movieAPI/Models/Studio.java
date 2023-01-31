package com.example.movieAPI.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Studio {
    @Id
    @GeneratedValue
    @Column(updatable=false, nullable = false)
    Integer Id;
    @Column
    String Name;
    @Column
    String Address;
    @OneToMany(mappedBy = "Studio")
    List<Movie> Movies;
}
