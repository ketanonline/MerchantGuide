/**
 *
 */
package com.thoughtworks.merchantguide.service;

/**
 * @author ketz
 */
public class UnknownMessageProcessor extends MessageProcessor {
    private static UnknownMessageProcessor obj = new UnknownMessageProcessor();

    private UnknownMessageProcessor() {
    }

    static UnknownMessageProcessor getInstance() {
        return obj;
    }

    public IntergalacticUnitConverterServiceResponse process(IntergalacticUnitConverterServiceRequest msg) {
        return new IntergalacticUnitConverterServiceResponse("I have no idea what you are talking about");
    }

}
