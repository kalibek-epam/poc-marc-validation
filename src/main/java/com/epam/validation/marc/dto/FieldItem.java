package com.epam.validation.marc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * MARC Field
 */

@Schema(name = "fieldItem", description = "MARC Field")
@JsonTypeName("fieldItem")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-11T18:27:36.277406700+06:00[Asia/Almaty]")
public class FieldItem {

  private String tag;

  private Object content;

  @Valid
  private List<@Size(min = 1, max = 1)String> indicators;

  private Boolean isProtected;

  private LinkDetails linkDetails;

  public FieldItem tag(String tag) {
    this.tag = tag;
    return this;
  }

  /**
   * Field's tag
   * @return tag
  */
  @NotNull @Pattern(regexp = "^[0-9]{3}$") 
  @Schema(name = "tag", example = "1", description = "Field's tag", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tag")
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public FieldItem content(Object content) {
    this.content = content;
    return this;
  }

  /**
   * Field's content
   * @return content
  */
  @NotNull 
  @Schema(name = "content", example = "$a 393893 $b Mike", description = "Field's content", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("content")
  public Object getContent() {
    return content;
  }

  public void setContent(Object content) {
    this.content = content;
  }

  public FieldItem indicators(List<@Size(min = 1, max = 1)String> indicators) {
    this.indicators = indicators;
    return this;
  }

  public FieldItem addIndicatorsItem(String indicatorsItem) {
    if (this.indicators == null) {
      this.indicators = new ArrayList<>();
    }
    this.indicators.add(indicatorsItem);
    return this;
  }

  /**
   * Field's indicators
   * @return indicators
  */
  @Size(min = 0, max = 2) 
  @Schema(name = "indicators", description = "Field's indicators", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("indicators")
  public List<@Size(min = 1, max = 1)String> getIndicators() {
    return indicators;
  }

  public void setIndicators(List<@Size(min = 1, max = 1)String> indicators) {
    this.indicators = indicators;
  }

  public FieldItem isProtected(Boolean isProtected) {
    this.isProtected = isProtected;
    return this;
  }

  /**
   * Flag indicates if the field data is protected
   * @return isProtected
  */
  
  @Schema(name = "isProtected", accessMode = Schema.AccessMode.READ_ONLY, example = "true", description = "Flag indicates if the field data is protected", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isProtected")
  public Boolean getIsProtected() {
    return isProtected;
  }

  public void setIsProtected(Boolean isProtected) {
    this.isProtected = isProtected;
  }

  public FieldItem linkDetails(LinkDetails linkDetails) {
    this.linkDetails = linkDetails;
    return this;
  }

  /**
   * Get linkDetails
   * @return linkDetails
  */
  @Valid 
  @Schema(name = "linkDetails", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("linkDetails")
  public LinkDetails getLinkDetails() {
    return linkDetails;
  }

  public void setLinkDetails(LinkDetails linkDetails) {
    this.linkDetails = linkDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldItem fieldItem = (FieldItem) o;
    return Objects.equals(this.tag, fieldItem.tag) &&
        Objects.equals(this.content, fieldItem.content) &&
        Objects.equals(this.indicators, fieldItem.indicators) &&
        Objects.equals(this.isProtected, fieldItem.isProtected) &&
        Objects.equals(this.linkDetails, fieldItem.linkDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tag, content, indicators, isProtected, linkDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldItem {\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    indicators: ").append(toIndentedString(indicators)).append("\n");
    sb.append("    isProtected: ").append(toIndentedString(isProtected)).append("\n");
    sb.append("    linkDetails: ").append(toIndentedString(linkDetails)).append("\n");
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

