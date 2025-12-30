package com.nvp18.jobtracker.dao;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Company")
public class CompanyDao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="companyId")
    private String companyId;

    @Column(name="companyName", nullable = false, unique = true)
    private String companyName;

    @Column(name="companySlug", nullable = false)
    private String companySlug;

    @ManyToOne
    @JoinColumn(name="atsId", referencedColumnName = "atsId")
    private JobBoardDao jobBoardDao;
}
