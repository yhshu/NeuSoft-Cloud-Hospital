package com.neusoft.medical.service.impl;

import com.neusoft.medical.Util.Constant;
import com.neusoft.medical.service.registration.InvoiceService;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public String getInvoiceState(int i) {
        if (i == Constant.INVOICE_VALID) return "有效";
        if (i == Constant.INVOICE_RUSHED) return "红冲";
        if (i == Constant.INVOICE_REINVOICE) return "重打";
        return null;
    }
}
