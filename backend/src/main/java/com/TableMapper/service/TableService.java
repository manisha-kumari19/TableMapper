package com.TableMapper.service;

import com.TableMapper.Dto.Fields;
import com.TableMapper.Dto.JsonData;
import com.TableMapper.mapper.TableMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class TableService {


    public String generateScript(TableMapper data) {
        StringBuilder script = new StringBuilder("INSERT INTO ")
                .append(data.getTableName())
                .append(" (");

        // Append column names
        int totalColumns = data.getFields().size();
        int currentColumn = 0;
        for (Map.Entry<String, Fields> entry : data.getFields().entrySet()) {
            String column = entry.getValue().getMappedTo();
            script.append(column);
            if (++currentColumn < totalColumns) {
                script.append(", ");
            }
        }

        script.append(") VALUES (");

        // Append values
        int currentValue = 0;
        for (Map.Entry<String, Fields> entry : data.getFields().entrySet()) {
            Fields field = entry.getValue();
            script.append("'").append(field.getValue()).append("'");
            if (++currentValue < totalColumns) {
                script.append(", ");
            }
        }

        script.append(");");

        System.out.println("script:  " + script.toString());
        return script.toString();
    }







//    public TableMapper getMapperFromJSON(String tableName , Map<String,Fields> fieldData)
//    {
//        TableMapper tableMapper=new TableMapper();
//        tableMapper.setTableName(tableName);
//        Map<String,Fields> fields= jsonData.getFields();
//        for(String key : fields.keySet())
//        {
//            Fields field=new Fields();
//            field.setValue(fields.get(key).toString());
//
//
//        }
//        return tableMapper;
//    }
}
