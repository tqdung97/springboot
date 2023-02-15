package com.example.basic.repository;

import com.example.basic.entity.UserInfo;
import com.example.basic.entity.User;
import com.example.basic.entity.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Method query
    List<User> findByName(String name);

    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findByAgeGreaterThan(Integer age);

    boolean existsByEmail(String email);

    long countByAgeBetween(Integer min, Integer max);

    Optional<User> findByEmail(String email);

    // JPQL Query : JPA Query Language
    @Query("select u from User u where u.name = ?1")
    List<User> findByNameJPQL(String name);

    @Query("select count(u) from User u where u.age between ?1 and ?2")
    long countByAgeBetweenJPQL(Integer min, Integer max);

    @Query("select u from User u where u.email = :emailValue")
    Optional<User> findByEmailJPQL(@Param("emailValue") String email);

    @Query(name = "User.findByAge")
    List<User> findByAgeJPQL(Integer age);

    // Native Query
    @Query(nativeQuery = true, value = "select * from user u where u.name = ?1")
    List<User> findByNameNative(String name);

    // Update
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update user u set u.name = ?2 where u.id = ?1")
    void updateNameUser(Integer id, String name);

    @Transactional
    @Modifying
    @Query("update User u set u.name = :name, u.email = :email, u.age = :age where u.id = :id")
    void updateInfoUser(@Param("name") String name, @Param("email") String email, @Param("age") Integer age, @Param("id") Integer id);

    // Lấy Dto sử dụng JPQL
//    @Query("select new com.example.basic.dto.UserDto(u.id, u.name, u.email) from User u")
    @Query("select new com.example.basic.dto.UserDto(u.id, u.name, u.email) " +
            "from User u where upper(u.email) like upper(concat('%', ?1, '%'))")
    List<UserDto> findByEmailContainingIgnoreCase(String email);

    // Lấy entity => map sang dto tương ứng
    List<User> findByNameStartingWith(String prefix);

    @Query(name = "findAllUserDto", nativeQuery = true)
    List<UserDto> findAllUserDto();

    // Sủ dụng projection jpa
    List<UserInfo> findUserInfoByNameStartingWith(String prefix);
}