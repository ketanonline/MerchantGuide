package com.thoughtworks.merchantguide.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ketz on 3/30/2017.
 */
public class UnknownMessageProcessorTest {
    @Test
    public void process() throws Exception {
        MessageProcessor processor = UnknownMessageProcessor.getInstance();

        IntergalacticUnitConverterServiceResponse response = processor.process(new IntergalacticUnitConverterServiceRequest("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
        Assert.assertEquals("I have no idea what you are talking about", response.getValue());
    }

}