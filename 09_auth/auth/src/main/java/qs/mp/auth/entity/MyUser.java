package qs.mp.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyUser {

    private int id;

    private String username;
    private List<String> userRoles;

    public MyUser(int id, String username, List<String> userRoles) {
        this.id = id;
        this.username = username;
        this.userRoles = userRoles;
    }
}
