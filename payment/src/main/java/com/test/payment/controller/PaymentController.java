package com.test.payment.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.test.payment.dto.PaymentRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private IamportClient iamportClient;

    @Value("${imp.api.key}")
    private String apiKey;

    @Value("${imp.api.secretkey}")
    private String secretKey;

    @PostConstruct
    public void init() {
        this.iamportClient = new IamportClient(apiKey, secretKey);
    }

    @GetMapping("/payment")
    public String paymentPage(Model model) {
        model.addAttribute("impKey", apiKey);
        return "payment";
    }

    @RestController
    @RequestMapping("/api/v1/payments")
    public class PaymentApiController {
        
        @GetMapping("/verify/{imp_uid}")
        public ResponseEntity<?> verifyPayment(
                @PathVariable String imp_uid,
                @RequestParam String merchant_uid,
                @RequestParam BigDecimal amount) {
            try {
                IamportResponse<Payment> payment = iamportClient.paymentByImpUid(imp_uid);
                
                if (payment.getResponse().getAmount().compareTo(amount) == 0 && 
                    payment.getResponse().getMerchantUid().equals(merchant_uid)) {
                    return ResponseEntity.ok(payment.getResponse());
                } else {
                    return ResponseEntity.badRequest().body("결제 금액이 일치하지 않습니다.");
                }
            } catch (IamportResponseException | IOException e) {
                log.error("결제 검증 중 오류 발생", e);
                return ResponseEntity.badRequest().body("결제 검증 중 오류가 발생했습니다: " + e.getMessage());
            }
        }

        @GetMapping("/status/{imp_uid}")
        public ResponseEntity<?> getPaymentStatus(@PathVariable String imp_uid) {
            try {
                IamportResponse<Payment> payment = iamportClient.paymentByImpUid(imp_uid);
                return ResponseEntity.ok(payment.getResponse());
            } catch (IamportResponseException | IOException e) {
                log.error("결제 상태 조회 중 오류 발생", e);
                return ResponseEntity.badRequest().body("결제 상태 조회 중 오류가 발생했습니다: " + e.getMessage());
            }
        }
    }
}
