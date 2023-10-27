package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paymentDetails")
@Data
@NoArgsConstructor
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal merchantPaymentAmount;
    private BigDecimal commissionAmount;
    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail", cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public PaymentDetail(BigDecimal merchantPaymentAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchantPaymentAmount = merchantPaymentAmount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }
}
