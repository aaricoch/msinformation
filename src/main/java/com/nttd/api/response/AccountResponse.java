package com.nttd.api.response;

import lombok.Data;

@Data
public class AccountResponse {
    private long IdAccountCustomer;
    private String flag_creation;
    private double current_amount;
    private double starting_amount;
    private String description;
    private String flag_account;
    private String startdate;
    private String courtdate;
    private int quota;
    private String paymentdate;
    private String state;
    private String accountnumber;
    private long IdCustomer;
    private long IdBANKCARD;

    public AccountResponse() {
    }

    public AccountResponse(String flag_creation, double current_amount, double starting_amount) {
        this.flag_creation = flag_creation;
        this.current_amount = current_amount;
        this.starting_amount = starting_amount;
    }

    
}
