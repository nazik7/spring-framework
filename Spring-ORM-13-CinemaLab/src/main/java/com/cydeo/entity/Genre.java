package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Genre extends BaseEntity{
    private String name;
    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movie;

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
