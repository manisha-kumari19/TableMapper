    package com.TableMapper.Controller;


    import com.TableMapper.Dto.Fields;
    import com.TableMapper.Dto.JsonData;
    import com.TableMapper.mapper.TableMapper;
    import com.TableMapper.service.TableService;
    import com.fasterxml.jackson.core.JsonParser;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.io.IOException;
    import java.util.HashMap;
    import java.util.LinkedHashMap;
    import java.util.Map;

    @RestController
    @RequestMapping("/")
    public class TableController {


        @Autowired
        private TableService tableService;
        @PostMapping("script")
        public String GenerateSCript(@RequestBody JsonData json) throws IOException {

            String tableName = json.getTableName();

            Map<String, Object> fields = json.getFields();
            ObjectMapper objectMapper = new ObjectMapper();
            //JsonData jsonData = objectMapper.readValue(json, JsonData.class);
            Map<String,Fields> fieldsData=new HashMap<>();

            for (String key : fields.keySet()) {
                // Extracting the JSON representation of each field
                String fieldJson = objectMapper.writeValueAsString(fields.get(key));

                // Deserializing the JSON into the Fields class
                Fields field = objectMapper.readValue(fieldJson, Fields.class);

                fieldsData.put(key,field);

            }

            TableMapper tableMapper=new TableMapper(tableName,fieldsData);
            for(String key : fieldsData.keySet())
            {
                System.out.println(key+"-----"+fieldsData.get(key));
            }
            String script = tableService.generateScript(tableMapper);


            return "success";
        }
    }
