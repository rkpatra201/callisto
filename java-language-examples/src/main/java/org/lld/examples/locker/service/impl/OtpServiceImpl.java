package org.lld.examples.locker.service.impl;

import org.lld.examples.locker.service.OtpService;

import java.util.Random;

public class OtpServiceImpl implements OtpService {

    @Override
    public String generateOtp() {
        // Generate a 4-digit OTP
        return String.format("%04d", new Random().nextInt(10000));
    }
}
