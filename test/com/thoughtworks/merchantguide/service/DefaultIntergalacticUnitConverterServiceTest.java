package com.thoughtworks.merchantguide.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DefaultIntergalacticUnitConverterServiceTest {

    @Test
    public void testService() {
        DefaultIntergalacticUnitConverterService service = new DefaultIntergalacticUnitConverterService();
        List<IntergalacticUnitConverterServiceRequest> input = new ArrayList<>();
        input.add(new IntergalacticUnitConverterServiceRequest("glob is I."));
        input.add(new IntergalacticUnitConverterServiceRequest("prok is V"));
        input.add(new IntergalacticUnitConverterServiceRequest("pish is X"));
        input.add(new IntergalacticUnitConverterServiceRequest("tegj is L"));
        input.add(new IntergalacticUnitConverterServiceRequest("glob glob Silver is 34 Credits"));
        input.add(new IntergalacticUnitConverterServiceRequest("glob prok Gold is 57800 Credits"));
        input.add(new IntergalacticUnitConverterServiceRequest("pish pish Iron is 3910 Credits"));
        input.add(new IntergalacticUnitConverterServiceRequest("how much is pish tegj glob glob ?"));
        input.add(new IntergalacticUnitConverterServiceRequest("how many Credits is glob prok Silver ?"));
        input.add(new IntergalacticUnitConverterServiceRequest("how many Credits is glob prok Gold ?"));
        input.add(new IntergalacticUnitConverterServiceRequest("how many Credits is glob prok Iron ?"));
        input.add(new IntergalacticUnitConverterServiceRequest("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
        List<IntergalacticUnitConverterServiceResponse> responses = service.convert(input);
        Assert.assertEquals("pish tegj glob glob is 42", responses.get(0).getValue());
        Assert.assertEquals("glob prok Silver is 68 Credits", responses.get(1).getValue());
        Assert.assertEquals("glob prok Gold is 57800 Credits", responses.get(2).getValue());
        Assert.assertEquals("glob prok Iron is 782 Credits", responses.get(3).getValue());
        Assert.assertEquals("I have no idea what you are talking about", responses.get(4).getValue());
    }

}
