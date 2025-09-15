package me.lobilux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Properties {
    @Id
    private Long id = 1L;

    @Column(name = "penalty_per_day", precision = 5, scale = 2, nullable = false)
    private BigDecimal penaltyPerDay = BigDecimal.valueOf(0);

    @Column(name = "penalty_on_non_working_days", nullable = false)
    private Boolean penaltyOnNonWorkingDays = false;

    @Column(name = "penalty_multiplier_on_non_working_days", precision = 5, scale = 2, nullable = false)
    private BigDecimal penaltyMultiplierOnNonWorkingDays = BigDecimal.valueOf(2);

    @Column(name = "count_loan_days_on_non_working_days", nullable = false)
    private Boolean countLoanDaysOnNonWorkingDays = false;

    @Column(name = "charge_late_fee_and_book_replacement_together", nullable = false)
    private Boolean chargeLateFeeAndBookReplacementTogether = true;

    @Column(name = "max_extensions", nullable = false)
    private Integer maxExtensions = 3;

    @Column(name = "max_loan_days", nullable = false)
    private Integer maxLoanDays = 5;

    @Column(name = "max_loans_per_user", nullable = false)
    private Integer maxLoansPerUser = 3;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
