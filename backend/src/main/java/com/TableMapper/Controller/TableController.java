    package com.TableMapper.Controller;


    import com.TableMapper.Dto.Fields;
    import com.TableMapper.Dto.JsonData;
    import com.fasterxml.jackson.core.JsonParser;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.io.IOException;
    import java.util.Map;

    @RestController
    @RequestMapping("/")
    public class TableController {

        @PostMapping("script")
        public String GenerateSCript(@RequestBody JsonData json) throws IOException {

            String parentTable = json.getParentTable();
            System.out.println(parentTable);

            Map<String, Object> fields = json.getFields();
            ObjectMapper objectMapper = new ObjectMapper();
            //JsonData jsonData = objectMapper.readValue(json, JsonData.class);


            for (String key : fields.keySet()) {
                // Extracting the JSON representation of each field
                String fieldJson = objectMapper.writeValueAsString(fields.get(key));

                // Deserializing the JSON into the Fields class
                Fields field = objectMapper.readValue(fieldJson, Fields.class);

                // Now you can access the properties of the Fields class
                System.out.println("  MappedTo: " + field.getMappedTo());
                System.out.println("  Value: " + field.getValue());
                System.out.println("  Referenced Column: " + field.getReferencedColumn());
            }



            return "success";
        }
    }
