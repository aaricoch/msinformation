package com.nttd.api.response;

import java.util.List;

import lombok.Data;

@Data
public class OperationResponse {
    private int code;
    private String message;
    private List<AccountResponse> listaccount;
    private AccountResponse account;
    private String errorMessage;
    private String description;

    public OperationResponse() {
    }
}
