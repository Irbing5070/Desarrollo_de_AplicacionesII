package mx.utng.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.utng.practice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
