package com.fintech.dto;

public class LinkAccountRequest {

    private String accountNumber;
    private String accountType;
    private String provider;

    // No-args constructor
    public LinkAccountRequest() {}

    // All-args constructor (private for builder)
    private LinkAccountRequest(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.accountType = builder.accountType;
        this.provider = builder.provider;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getProvider() {
        return provider;
    }

    // Builder class
    public static class Builder {
        private String accountNumber;
        private String accountType;
        private String provider;

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder provider(String provider) {
            this.provider = provider;
            return this;
        }

        public LinkAccountRequest build() {
            return new LinkAccountRequest(this);
        }
    }
}
