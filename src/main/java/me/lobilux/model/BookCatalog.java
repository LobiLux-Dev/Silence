package me.lobilux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BookCatalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn", length = 13, unique = true)
    private String isbn;

    @Column(name = "year_of_publication", nullable = false)
    private Short yearOfPublication;

    @ManyToOne(optional = false)
    @JoinColumn(name = "publisher_catalog_id", nullable = false)
    private PublisherCatalog publisherCatalog;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dewey_classification_id", nullable = false)
    private DeweyClassification deweyClassification;

    @OneToMany(mappedBy = "bookCatalog")
    private List<Book> books = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "BookCatalog_AuthorCatalog",
            joinColumns = @JoinColumn(name = "book_catalog_id"),
            inverseJoinColumns = @JoinColumn(name = "author_catalog_id")
    )
    private List<AuthorCatalog> authorsCatalog = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "BookCatalog_GenreCatalog",
            joinColumns = @JoinColumn(name = "book_catalog_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_catalog_id")
    )
    private List<GenreCatalog> genresCatalog = new ArrayList<>();
}
