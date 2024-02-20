package com.aleksnose.hoteru.service;

import com.aleksnose.hoteru.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private IRepository repository;
    public UserService(IRepository repository) {
        this.repository = repository;
    }

    public String test()
    {
        return "Test";
    }
}
