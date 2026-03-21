package com.bel.gymlens.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_info")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private Double height;

    @Column(name = "age")
    private Integer age;
}
