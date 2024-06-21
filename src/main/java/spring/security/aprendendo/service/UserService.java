package spring.security.aprendendo.service;

import spring.security.aprendendo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.security.aprendendo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User criar(User request){
        return userRepo.save(request);
    }

    public User pegar(Long id){
        return userRepo.findById(id).get();
    }
}
