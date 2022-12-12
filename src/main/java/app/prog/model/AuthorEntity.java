package app.prog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "author")
public class AuthorEntity {
    @Id
    private int id;
    private String name;
    private	String particularity;
    public boolean hasParticularity() {
        return particularity != null;
    }

}
