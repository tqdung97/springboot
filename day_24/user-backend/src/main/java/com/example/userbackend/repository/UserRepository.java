package com.example.userbackend.repository;

import com.example.userbackend.model.User;
import com.example.userbackend.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select new com.example.userbackend.model.dto.UserDto(u.id, u.name, u.email, u.phone, u.address, u.avatar) from User u")
    List<UserDto> findAllUserDto();

    @Query("select new com.example.userbackend.model.dto.UserDto(u.id, u.name, u.email, u.phone, u.address, u.avatar) " +
            "from User u " +
            "where upper(u.name) like upper(concat('%', ?1, '%'))")
    List<UserDto> findUserDtoByNameContainingIgnoreCase(String name);

    List<User> findByNameContainingIgnoreCase(String name);

    Optional<User> findByEmail(String email);
}
