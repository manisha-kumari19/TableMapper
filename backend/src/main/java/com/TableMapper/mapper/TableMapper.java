package com.TableMapper.mapper;

import com.TableMapper.strategy.Strategy;
import lombok.*;

import java.util.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TableMapper {

   private String tableName;
   private String parentTableName;
  private Map<String,Object> fields;


}
