package com.thoughtworks.merchantguide;

import com.thoughtworks.merchantguide.service.IntergalacticUnitConverterService;
import com.thoughtworks.merchantguide.service.IntergalacticUnitConverterServiceRequest;
import com.thoughtworks.merchantguide.service.IntergalacticUnitConverterServiceResponse;
import com.thoughtworks.merchantguide.service.ServiceFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MerchantGuide {

    public static void main(String[] args) {

        MerchantGuide guide = new MerchantGuide();
        args = new String[]{"input.txt"};
        guide.validateInput(args);
        File file = new File(args[0]);
        List<IntergalacticUnitConverterServiceRequest> input = guide.prepareInputForServiceCall(file);
        IntergalacticUnitConverterService service = ServiceFactory.createIntergalacticUnitConverterService();
        List<IntergalacticUnitConverterServiceResponse> results = service.convert(input);
        for (IntergalacticUnitConverterServiceResponse res : results) {
            System.out.println(res.getValue());
        }
    }

    private void validateInput(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("Only 1 argument is allowed. Provide valid file name as an argument");
        }
        File file = new File(args[0]);

        if (!file.isFile()) {
            throw new IllegalArgumentException("Please valid input file as an argument");
        }
    }

    private List<IntergalacticUnitConverterServiceRequest> prepareInputForServiceCall(File file) {
        String line;
        List<IntergalacticUnitConverterServiceRequest> input = new ArrayList<>();
        try (BufferedReader bir = new BufferedReader(new FileReader(file))) {
            while ((line = bir.readLine()) != null) {
                input.add(new IntergalacticUnitConverterServiceRequest(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(input);
        return input;
    }

}
