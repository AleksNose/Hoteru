package com.aleksnose.hoteru.repository;

import com.aleksnose.hoteru.models.User;
import org.springframework.data.repository.CrudRepository;

public interface IRepository extends CrudRepository<User, Integer> {




    /*
    public void create();
    public void read(Long id);
    public void update(Long id);
    public void delete(Long id);
     */
}
