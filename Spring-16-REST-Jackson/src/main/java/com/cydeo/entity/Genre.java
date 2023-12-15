package com.cydeo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Genre extends BaseEntity{
    private String name;
    @ManyToMany(mappedBy = "genreList")
    @JsonIgnore
    private List<Movie> movie;

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
