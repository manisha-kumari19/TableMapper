package com.TableMapper.controller;

import com.TableMapper.mapper.TableMapper;
import com.TableMapper.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/")
public class TableController {
    @Autowired
    private  TableService tableService;
    @PostMapping("data/{tableName}")
    public ResponseEntity<String> generateScript(@RequestBody Map<String,Object> data , @PathVariable String tableName){
        TableMapper mapper=new TableMapper();
        mapper.setTableName(tableName);
        mapper.getIdField()
        String script=tableService.generateScript();
                //tableService.generateScript();
       return ResponseEntity.ok(script);
    }
}
