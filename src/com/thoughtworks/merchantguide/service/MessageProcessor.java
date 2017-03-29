/**
 *
 */
package com.thoughtworks.merchantguide.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ketz
 */
public abstract class MessageProcessor {
    static Map<String, String> units = new HashMap<>();

    MessageProcessor() {

    }

    public abstract IntergalacticUnitConverterServiceResponse process(IntergalacticUnitConverterServiceRequest msg);

}
