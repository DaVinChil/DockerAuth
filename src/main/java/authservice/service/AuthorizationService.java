package authservice.service;

import authservice.exception.InvalidCredentials;
import authservice.exception.UnauthorizedUser;
import authservice.model.Authorities;
import authservice.model.User;
import authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

    private UserRepository userRepository;

    @Autowired
    public AuthorizationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user){
        String name = user.getUser();
        String password = user.getPassword();
        if(isEmpty(name) || isEmpty(password)){
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(name, password);
        if(isEmpty(userAuthorities)){
            throw new UnauthorizedUser("Unknown user " + name);
        }

        return userAuthorities;
    }

    private boolean isEmpty(String str){
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str){
        return str == null || str.isEmpty();
    }
}
