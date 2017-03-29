package com.thoughtworks.merchantguide.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ketz on 3/30/2017.
 */
public class UnitsMessageProcessorTest {
    @Test
    public void testMapKeywordToRomanUnit() throws Exception {
        UnitsMessageProcessor processor = new UnitsMessageProcessor();
        processor.process(new IntergalacticUnitConverterServiceRequest("glob is I"));
        processor.process(new IntergalacticUnitConverterServiceRequest("Glob is I."));
        Map<String, String> expected = new HashMap<>();
        expected.put("GLOB", "I");
        Map<String, String> actual = processor.forTestOnly_getUnitsMap();
        for (String k : expected.keySet()) {
            Assert.assertEquals(expected.get(k), actual.get(k));
        }
    }

    @Test
    public void testMapKeywordOtherMaterialUnit() throws Exception {
        UnitsMessageProcessor processor = new UnitsMessageProcessor();
        processor.process(new IntergalacticUnitConverterServiceRequest("glob glob Silver is 34 Credits"));
        //processor.process(new IntergalacticUnitConverterServiceRequest("Glob is I."));
        Map<String, String> expected = new HashMap<>();
        expected.put("SILVER", "34");
        Map<String, String> actual = processor.forTestOnly_getUnitsMap();
        for (String k : expected.keySet()) {
            Assert.assertEquals(expected.get(k), actual.get(k));
        }
    }

}