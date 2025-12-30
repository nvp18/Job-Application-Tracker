package com.nvp18.jobtracker.dao;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="JobBoards")
public class JobBoardDao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="atsId")
    private String atsId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="baseUrl", unique = true, nullable = false)
    private String baseUrl;

    @Column(name = "requiresAuth", nullable = false)
    private Boolean requiresAuth;

    @Column(name = "hasJobUrl", nullable = false)
    private Boolean hasJobUrl;

    @Column(name = "jobUrl")
    private String jobUrl;
}
