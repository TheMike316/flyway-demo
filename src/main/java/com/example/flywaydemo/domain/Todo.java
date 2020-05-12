package com.example.flywaydemo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo extends BaseEntity {

    private String title;

    private String description;

    @Builder.Default
    private Boolean completed = false;

    @ManyToOne
    private User user;
}
