package ponte.homework.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mysql.cj.xdevapi.JsonString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.LoginService;

@RestController
@RequestMapping("/api/user")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getUserDetails(@RequestBody JsonString userDetails){
        logger.warn(userDetails.toString());
        return null;
    }
}
