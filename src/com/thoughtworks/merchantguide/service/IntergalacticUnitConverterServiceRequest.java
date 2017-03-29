/**
 *
 */
package com.thoughtworks.merchantguide.service;

/**
 * @author ketz
 */
public class IntergalacticUnitConverterServiceRequest {

    private final String value;

    public IntergalacticUnitConverterServiceRequest(String val) {
        this.value = val;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "IntergalacticUnitConverterServiceRequest{" +
                "value='" + value + '\'' +
                '}';
    }
}
