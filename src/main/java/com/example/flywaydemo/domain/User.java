package com.example.flywaydemo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Entity(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class User extends BaseEntity {

    private String username;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos;


    public User(String username, String password, List<Todo> todos) {
        this.username = username;
        this.password = password;
        setTodos(todos);
    }

    public void setTodos(List<Todo> todos) {
        Optional.ofNullable(todos)
                .ifPresentOrElse(
                        list -> {
                            this.todos = list;
                            // to properly store the foreign key
                            list.forEach(t -> t.setUser(this));
                        },
                        () -> this.todos = Collections.emptyList());
    }
}
