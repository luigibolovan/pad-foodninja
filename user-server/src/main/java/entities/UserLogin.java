package entities;

import lombok.Data;

@Data
public class UserLogin extends Entity{

    public UserLogin() {
        this.myTableType = TableType.USER_LOGIN;
    }

    private String username;
    private String password;
}
