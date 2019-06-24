package com.neusoft.medical.service.registration;

public interface ChargeService {
    boolean checkout(String checkoutJson);

    boolean refund(String refundJson);

    boolean withdrawRegistration(Integer registrationId);
}
