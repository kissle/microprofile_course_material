package qs.mp.servicea.serviceb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Author {

    private String name;

    public Author(String name) {
        this.name = name;
    }
}
