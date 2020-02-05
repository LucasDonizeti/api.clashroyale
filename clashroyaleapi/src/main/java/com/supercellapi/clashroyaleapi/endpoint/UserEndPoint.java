package com.supercellapi.clashroyaleapi.endpoint;

import com.supercellapi.clashroyaleapi.models.User;
import com.supercellapi.clashroyaleapi.repository.ContaRepository;
import com.supercellapi.clashroyaleapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * author LucasDonizeti
 */
@RestController
@RequestMapping("user")
public class UserEndPoint {
    private final UserRepository userDAO;

    @Autowired
    public UserEndPoint(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public ContaRepository contaDAO;

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        if (userDAO.existsById(id)) {
            User user = userDAO.findById(id).get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}/alldata")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllDataById(@PathVariable("id") Long id) {
        if (userDAO.existsById(id)) {
            User user = userDAO.findById(id).get();
            user.setContas(contaDAO.getByUser(user));
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> save(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return new ResponseEntity<>(userDAO.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userDAO.existsById(id)) {
            User user = userDAO.findById(id).get();
            if (user.getAdmin() == true) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            contaDAO.deleteByUserId(id);
            userDAO.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        if (userDAO.existsById(user.getId())) {
            return new ResponseEntity<>(userDAO.save(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
