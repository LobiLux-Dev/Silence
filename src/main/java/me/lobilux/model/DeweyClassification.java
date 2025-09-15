package me.lobilux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DeweyClassification")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeweyClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private DeweyClassification parent;

    @OneToMany(mappedBy = "parent")
    private List<DeweyClassification> childs = new ArrayList<>();

    @OneToMany(mappedBy = "deweyClassification")
    private List<BookCatalog> booksCatalog = new ArrayList<>();
}
