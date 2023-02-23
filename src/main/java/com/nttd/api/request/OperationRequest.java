package com.nttd.api.request;

import lombok.Data;

@Data
public class OperationRequest {
    private String customerCode;

    public OperationRequest() {
    }

    public OperationRequest(String customerCode) {
        this.customerCode = customerCode;
    }
}
