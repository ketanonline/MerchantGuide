/**
 *
 */
package com.thoughtworks.merchantguide.service;

/**
 * @author ketz
 */
public class ServiceFactory {

    public static IntergalacticUnitConverterService createIntergalacticUnitConverterService() {
        return new DefaultIntergalacticUnitConverterService();
    }
}
