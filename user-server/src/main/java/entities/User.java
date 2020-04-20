package entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User extends Entity {

    public User() {
        this.myTableType = TableType.USER;
    }

    private String firstName;
    private String lastName;
    private int age;
    private double weight;
}
