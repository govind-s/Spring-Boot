
package com.rangers.jdbctemplate.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@SuppressWarnings("rawtypes")
public class PagedListSerializer extends JsonSerializer<List> {

  @Override
  public void serialize(List value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
    if (value instanceof PagedList) {
      PagedList value1 = (PagedList) value;
      gen.writeStartObject();
      gen.writeNumberField("totalRecords", value1.getTotalRecords());
      gen.writeObjectField("list", value1.getList());
      gen.writeEndObject();
    } else {
      gen.writeStartArray();
      for (Object obj : value) {
        gen.writeObject(obj);
      }
      gen.writeEndArray();
    }
  }

  @Override
  public Class<List> handledType() {
    return List.class;
  }
}
