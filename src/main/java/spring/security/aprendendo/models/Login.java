package spring.security.aprendendo.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_login")
public class Login implements UserDetails{
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Perfis de acesso
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public String getPassword() {
       return senha;
    }
    @Override
    public String getUsername() {
        return email;
    }
    
}
