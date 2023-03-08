package com.example.basic.entity;

import com.example.basic.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
                name = "listUserDto",
                classes = @ConstructorResult(
                        targetClass = UserDto.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "email", type = String.class)
                        }
                )
        )
})
@NamedNativeQuery(
        name = "findAllUserDto",
        resultSetMapping = "listUserDto",
        query = "select id, name, email from user")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.findByAge", query = "select u from User u where u.age = :age")
})
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "age")
    private Integer age;
}
