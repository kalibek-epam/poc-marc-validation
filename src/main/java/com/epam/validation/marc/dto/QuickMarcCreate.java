package com.epam.validation.marc.dto;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;

/**
 * QuickMarcCreate
 */


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-11T18:27:36.277406700+06:00[Asia/Almaty]")
public class QuickMarcCreate extends BaseMarcRecord {


  public QuickMarcCreate leader(String leader) {
    super.leader(leader);
    return this;
  }

  public QuickMarcCreate fields(List<@Valid FieldItem> fields) {
    super.fields(fields);
    return this;
  }

  public QuickMarcCreate addFieldsItem(FieldItem fieldsItem) {
    super.addFieldsItem(fieldsItem);
    return this;
  }

  public QuickMarcCreate suppressDiscovery(Boolean suppressDiscovery) {
    super.suppressDiscovery(suppressDiscovery);
    return this;
  }

  public QuickMarcCreate marcFormat(MarcFormat marcFormat) {
    super.marcFormat(marcFormat);
    return this;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuickMarcCreate {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

