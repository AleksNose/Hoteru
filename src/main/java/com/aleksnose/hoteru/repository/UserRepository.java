package com.aleksnose.hoteru.repository;

import com.aleksnose.hoteru.models.User;
import com.aleksnose.hoteru.models.WorkerInHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    default User findByNameAndSurname(String name, String surname) {
        var users = findAll();
        var foundUser = users.stream()
                .filter(user -> user.getName().equals(name) && user.getSurname().equals(surname))
                .findAny()
                .orElseThrow(() -> null);

        return foundUser;
    }

}
