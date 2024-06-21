package spring.security.aprendendo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.security.aprendendo.models.Login;
import spring.security.aprendendo.security.TokenGenerated;
import spring.security.aprendendo.security.TokenJWT;

@RestController
@RequestMapping("/soluevo/login")
public class Authentication {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenGenerated tokenGenerated;

    @PostMapping
    public ResponseEntity<TokenJWT> efetuarLogin(@RequestBody Login login){
        var token = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha());
        var authentication = authenticationManager.authenticate(token);

        var tokenJWT = tokenGenerated.gerarToken((Login) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }
}
