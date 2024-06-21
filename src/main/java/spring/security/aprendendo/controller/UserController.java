package spring.security.aprendendo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import spring.security.aprendendo.models.User;
import spring.security.aprendendo.service.UserService;

@RestController
@RequestMapping("/soluevo")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User request, UriComponentsBuilder uriBuilder){
        var response = userService.criar(request);
        var uri = uriBuilder.path("/soluevo/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        var response = userService.pegar(id);
        return ResponseEntity.ok().body(response);
    }
}
