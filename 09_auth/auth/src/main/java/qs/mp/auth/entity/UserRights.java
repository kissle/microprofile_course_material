package qs.mp.auth.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserRights {

    private String rsid;
    private List<String> scopes = new ArrayList<>();

    public UserRights(List<String> scopes) {
        this.scopes = scopes;
    }
}
