package spring.security.aprendendo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import spring.security.aprendendo.models.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long>{
    UserDetails findByEmail(String username);
    
} 