package edmond.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        boolean isValidUsername = username.equalsIgnoreCase("edi");
        boolean isValidPass = password.equals("123");
        return isValidUsername && isValidPass;
    }

}
