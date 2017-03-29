package com.thoughtworks.merchantguide.service;

public class IntergalacticUnitConverterServiceResponse {

    private String value;

    public IntergalacticUnitConverterServiceResponse(String val) {
        this.value = val;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "IntergalacticUnitConverterServiceResponse{" +
                "value='" + value + '\'' +
                '}';
    }
}
