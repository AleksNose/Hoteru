package com.aleksnose.hoteru.controller;

import com.aleksnose.hoteru.models.User;
import com.aleksnose.hoteru.models.WorkerInHotel;
import com.aleksnose.hoteru.repository.IRepository;
import com.aleksnose.hoteru.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidClassException;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    private IRepository repository;

    public UserController(UserService userService, IRepository repository) {
        this.userService = userService;
        this.repository = repository;
    }

    @GetMapping("/test")
    public String test() {
        return userService.test();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping(path="/worker/{id}")
    public Set<WorkerInHotel> getWorker(@PathVariable long id) throws InvalidClassException {

        Optional<User> user = repository.findById(id);

        if (user.isPresent())
        {
            if (user.get().getIsWorker())
            {
                return repository.findById(id).get().getWorkersInHotels();
            }

            throw new InvalidClassException("Isn't worker");
        }

        throw new InvalidClassException("Don't have user");
    }
}
