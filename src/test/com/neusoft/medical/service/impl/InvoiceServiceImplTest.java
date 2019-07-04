package com.neusoft.medical.service.impl;

import com.neusoft.medical.service.registration.InvoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceServiceImplTest {

    @Resource
    InvoiceService invoiceService;

    @Test
    public void getInvoiceState() {
        for (int i = 0; i<50; i++)
        invoiceService.getInvoiceState(i);
    }
}