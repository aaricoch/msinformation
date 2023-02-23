package com.nttd.api.response;

import lombok.Data;

@Data
public class AuditResponse {
    private int code;
    private String message;
    private String errorMessage;
    private String description;
    private Object response;
}
