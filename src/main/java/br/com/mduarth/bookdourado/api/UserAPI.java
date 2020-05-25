package br.com.mduarth.bookdourado.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.mduarth.bookdourado.model.ResponseApi;
import br.com.mduarth.bookdourado.model.User;
import br.com.mduarth.bookdourado.model.UserDto;
import br.com.mduarth.bookdourado.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserAPI {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> stock = userService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
        if (!userService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        if (!userService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        userService.deleteById(id);

        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<ResponseApi<UserDto>> login(@Valid @RequestBody User user) {
    	
        ResponseApi<UserDto> response = new ResponseApi<UserDto>();

    	Optional<User> stock = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (!stock.isPresent()) {
            log.error("User " + user.getUsername() + " is not existed");
            
            response.setData(null);
            response.setError("Usuário não existe");
            
            return ResponseEntity.ok(response);
        }

        response.setData(stock.get().convertDto(stock.get()));
        response.setError(null);
        
        return ResponseEntity.ok(response);
    }
}
