/**
 *
 */
package com.thoughtworks.merchantguide.service;

import com.thoughtworks.merchantguide.service.common.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ketz
 */
public class DefaultIntergalacticUnitConverterService implements IntergalacticUnitConverterService {

    /* (non-Javadoc)
     * @see com.thoughtworks.intergalacticconverter.IntergalacticUnitConverterService#convert(java.util.List)
     */
    @Override
    public List<IntergalacticUnitConverterServiceResponse> convert(List<IntergalacticUnitConverterServiceRequest> input) {
        List<IntergalacticUnitConverterServiceResponse> result = new ArrayList<>();
        for (IntergalacticUnitConverterServiceRequest req : input) {
            MessageProcessor processor = MessageProcessorFactory.createMessageProcessor(req);
            IntergalacticUnitConverterServiceResponse resp = processor.process(req);
            if (!resp.equals(Constants.DUMMY_INTERGALACTIC_UNIT_CONVERTER_SERVICE_RESPONSE)) {
                result.add(resp);
            }
        }

        return result;
    }
}
