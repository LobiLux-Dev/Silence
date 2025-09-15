package me.lobilux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserRoleCatalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoleCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToMany(mappedBy = "userRoleCatalog")
    private List<User> users = new ArrayList<>();
}
