package com.epam.validation.marc.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * MARC Format
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-11T18:27:36.708579500+06:00[Asia/Almaty]")
public enum MarcFormat {
  
  BIBLIOGRAPHIC("BIBLIOGRAPHIC"),
  
  HOLDINGS("HOLDINGS"),
  
  AUTHORITY("AUTHORITY");

  private String value;

  MarcFormat(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static MarcFormat fromValue(String value) {
    for (MarcFormat b : MarcFormat.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

