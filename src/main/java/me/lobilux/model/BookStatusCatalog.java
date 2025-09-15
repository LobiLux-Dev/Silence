package me.lobilux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BookStatusCatalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookStatusCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "bookStatusCatalog")
    private List<Book> books = new ArrayList<>();
}
