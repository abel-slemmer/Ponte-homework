package ponte.homework.domain.dto;

import lombok.Data;

@Data
public class UserDetails {

    private String loginId;
    private String password;

    public UserDetails(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
