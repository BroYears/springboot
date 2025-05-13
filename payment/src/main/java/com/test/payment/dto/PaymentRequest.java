package com.test.payment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentRequest {
    private String merchantUid;  // 주문번호
    private String productName;  // 상품명
    private Integer amount;         // 결제금액
    private String buyerEmail;  // 구매자 이메일
    private String buyerName;   // 구매자 이름
    private String buyerTel;    // 구매자 전화번호
} 