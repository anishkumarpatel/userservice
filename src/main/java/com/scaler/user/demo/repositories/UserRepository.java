package com.scaler.user.demo.repositories;

import com.scaler.user.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User save(User user);

    public Optional<User> findById(Long id);

    public void deleteById(Long id);

    public Optional<User> findByUsernameAndPassword(String username, String password);

    public List<User> findAll();
}
