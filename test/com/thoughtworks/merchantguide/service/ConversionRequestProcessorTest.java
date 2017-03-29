package com.thoughtworks.merchantguide.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ketz on 3/30/2017.
 */
public class ConversionRequestProcessorTest {
    @Test
    public void testProcess() throws Exception {
        String[] inarr = {"how many Credits is pish tegj glob glob SILVER?",
                "how many Credits is pish tegj glob glob SILVER.",
                "how much is pish tegj glob glob ?",
                "how many Credits is glob prok Silver ?",
                "how many Credits is glob prok Gold ?",
                "how many Credits is glob prok Iron ?",
        };
        ConversionRequestProcessor processor = new ConversionRequestProcessor();
        Map<String, String> map = new HashMap<>();
        map.put("GLOB", "I");
        map.put("PISH", "X");
        map.put("PROK", "V");
        map.put("TEGJ", "L");
        map.put("SILVER", "17");
        map.put("GOLD", "14450");
        map.put("IRON", "195.5");
        processor.forTestOnly_setUnitsMap(map);
        List<IntergalacticUnitConverterServiceResponse> intergalacticUnitConverterServiceResponses = new ArrayList<>();
        for (String in : inarr) {
            IntergalacticUnitConverterServiceResponse r = processor.process(new IntergalacticUnitConverterServiceRequest(in));
            intergalacticUnitConverterServiceResponses.add(r);
        }
        Assert.assertEquals(intergalacticUnitConverterServiceResponses.get(0).getValue(), "pish tegj glob glob SILVER is 714 Credits");
        Assert.assertEquals(intergalacticUnitConverterServiceResponses.get(1).getValue(), "pish tegj glob glob SILVER is 714 Credits");
        Assert.assertEquals(intergalacticUnitConverterServiceResponses.get(2).getValue(), "pish tegj glob glob is 42");
        Assert.assertEquals(intergalacticUnitConverterServiceResponses.get(3).getValue(), "glob prok Silver is 68 Credits");
        Assert.assertEquals(intergalacticUnitConverterServiceResponses.get(4).getValue(), "glob prok Gold is 57800 Credits");
        Assert.assertEquals(intergalacticUnitConverterServiceResponses.get(5).getValue(), "glob prok Iron is 782 Credits");

    }

}