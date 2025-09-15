package me.lobilux.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AppUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_role_catalog_id", nullable = false)
    private UserRoleCatalog userRoleCatalog;

    @OneToMany(mappedBy = "borrower")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Loan> loansAsBorrower = new ArrayList<>();

    @OneToMany(mappedBy = "issuedBy")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Loan> loansAsIssuer = new ArrayList<>();

    @OneToMany(mappedBy = "receivedBy")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Loan> loansAsReceiver = new ArrayList<>();

    @OneToMany(mappedBy = "calculatedBy")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Loan> loansAsCalculator = new ArrayList<>();
}
