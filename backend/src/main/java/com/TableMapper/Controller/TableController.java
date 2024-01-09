package com.TableMapper.Controller;


import com.TableMapper.Dto.JsonData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class TableController {

    @PostMapping("script")
    public String GenerateSCript(@RequestBody JsonData json){

        String parentTable = json.getParentTable();
        System.out.println(parentTable);

        Map<String, Object> fields = json.getFields();

        for (String key : fields.keySet()) {
            System.out.println("Field: " + key);

            // Accessing the nested map
            Map<String, Object> fieldDetails = (Map<String, Object>) fields.get(key);

            // Extracting the value of the 'mappedTo' field from the nested map
            Object mappedToValue = fieldDetails.get("mappedTo");

            System.out.println("  MappedTo: " + mappedToValue);
        }



        return "success";
    }
}
