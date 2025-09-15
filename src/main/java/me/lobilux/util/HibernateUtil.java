package me.lobilux.util;

import lombok.Getter;
import me.lobilux.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            System.out.println("Hibernate setup successful!");
            return new Configuration()
                    .configure()
                    .addAnnotatedClasses(
                            AuthorCatalog.class,
                            Book.class,
                            BookCatalog.class,
                            BookStatusCatalog.class,
                            DeweyClassification.class,
                            GenreCatalog.class,
                            Loan.class,
                            LoanStatus.class,
                            Properties.class,
                            PublisherCatalog.class,
                            User.class,
                            UserRoleCatalog.class
                    )
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error building SessionFactory");
        }
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
