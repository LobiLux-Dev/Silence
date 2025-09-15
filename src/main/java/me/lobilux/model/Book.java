package me.lobilux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "Book",
        uniqueConstraints = @UniqueConstraint(columnNames = { "book_catalog_id", "copy_number" })
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "copy_number", nullable = false)
    private Integer copyNumber;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_status_catalog_id", nullable = false)
    private BookStatusCatalog bookStatusCatalog;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_catalog_id", nullable = false)
    private BookCatalog bookCatalog;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans = new ArrayList<>();
}
