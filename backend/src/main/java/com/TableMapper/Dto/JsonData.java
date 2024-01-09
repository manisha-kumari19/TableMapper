package com.TableMapper.Dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JsonData {
   private String tableName;
   private String parentTable;



    Map<String, Object> fields = new LinkedHashMap<>();

    @JsonSetter
    void setFields(String key, Object value) {
        fields.put(key, value);
    }

    @JsonGetter
    public Map<String, Object> getFields() {
        return fields;
    }

}
