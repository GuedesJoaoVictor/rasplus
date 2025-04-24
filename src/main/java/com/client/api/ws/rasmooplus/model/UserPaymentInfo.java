package com.client.api.ws.rasmooplus.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Getter @Setter @ToString
// ou
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_payment_info")
public class UserPaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_payment_info_id")
    private Long id;
    @Column(name = "card_number", unique = true)
    private String cardNumber;
    @Column(name = "card_expiration_month")
    private Long cardExpirationMonth;
    @Column(name = "card_expiration_year")
    private Long cardExpirationYear;
    @Column(name = "card_security_code")
    private String cardSecurityCode;
    private BigDecimal price;
    @Column(name = "dt_payment")
    private LocalDate dtPayment;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
