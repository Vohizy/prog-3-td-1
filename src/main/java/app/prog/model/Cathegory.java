package app.prog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cathegory {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "cathegory")
    private List<BookEntity> books;
}
