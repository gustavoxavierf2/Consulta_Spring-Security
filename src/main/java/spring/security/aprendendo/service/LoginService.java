package spring.security.aprendendo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.security.aprendendo.models.Login;
import spring.security.aprendendo.repository.LoginRepo;

@Service
public class LoginService implements UserDetailsService{
    @Autowired
    private LoginRepo loginRepo;

    public Login autorizationLogin()  {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginRepo.findByEmail(username);

    }
}
