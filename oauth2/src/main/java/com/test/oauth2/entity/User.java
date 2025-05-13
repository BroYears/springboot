package com.test.oauth2.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
//@Table(name = "Member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblUser")
public class User {

    @Id
    @SequenceGenerator(sequenceName = "seqUser", name="member_seq_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    private String username;
    private String name;
    private String email;
    private Integer age;


}
