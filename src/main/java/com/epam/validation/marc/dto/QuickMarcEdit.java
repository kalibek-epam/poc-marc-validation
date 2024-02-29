package com.epam.validation.marc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * QuickMarcEdit
 */


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-11T18:27:36.277406700+06:00[Asia/Almaty]")
public class QuickMarcEdit extends BaseMarcRecord {

  private UUID parsedRecordId;

  private UUID parsedRecordDtoId;

  private UUID externalId;

  private String externalHrid;

  private String relatedRecordVersion;

  public QuickMarcEdit parsedRecordId(UUID parsedRecordId) {
    this.parsedRecordId = parsedRecordId;
    return this;
  }

  /**
   * Get parsedRecordId
   * @return parsedRecordId
  */
  @NotNull @Valid 
  @Schema(name = "parsedRecordId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parsedRecordId")
  public UUID getParsedRecordId() {
    return parsedRecordId;
  }

  public void setParsedRecordId(UUID parsedRecordId) {
    this.parsedRecordId = parsedRecordId;
  }

  public QuickMarcEdit parsedRecordDtoId(UUID parsedRecordDtoId) {
    this.parsedRecordDtoId = parsedRecordDtoId;
    return this;
  }

  /**
   * Get parsedRecordDtoId
   * @return parsedRecordDtoId
  */
  @NotNull @Valid 
  @Schema(name = "parsedRecordDtoId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parsedRecordDtoId")
  public UUID getParsedRecordDtoId() {
    return parsedRecordDtoId;
  }

  public void setParsedRecordDtoId(UUID parsedRecordDtoId) {
    this.parsedRecordDtoId = parsedRecordDtoId;
  }

  public QuickMarcEdit externalId(UUID externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * Get externalId
   * @return externalId
  */
  @NotNull @Valid 
  @Schema(name = "externalId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("externalId")
  public UUID getExternalId() {
    return externalId;
  }

  public void setExternalId(UUID externalId) {
    this.externalId = externalId;
  }

  public QuickMarcEdit externalHrid(String externalHrid) {
    this.externalHrid = externalHrid;
    return this;
  }

  /**
   * HRID of external entity
   * @return externalHrid
  */
  @NotNull 
  @Schema(name = "externalHrid", description = "HRID of external entity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("externalHrid")
  public String getExternalHrid() {
    return externalHrid;
  }

  public void setExternalHrid(String externalHrid) {
    this.externalHrid = externalHrid;
  }

  public QuickMarcEdit relatedRecordVersion(String relatedRecordVersion) {
    this.relatedRecordVersion = relatedRecordVersion;
    return this;
  }

  /**
   * Information related to version of the record
   * @return relatedRecordVersion
  */
  @NotNull 
  @Schema(name = "relatedRecordVersion", description = "Information related to version of the record", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("relatedRecordVersion")
  public String getRelatedRecordVersion() {
    return relatedRecordVersion;
  }

  public void setRelatedRecordVersion(String relatedRecordVersion) {
    this.relatedRecordVersion = relatedRecordVersion;
  }


  public QuickMarcEdit leader(String leader) {
    super.leader(leader);
    return this;
  }

  public QuickMarcEdit fields(List<@Valid FieldItem> fields) {
    super.fields(fields);
    return this;
  }

  public QuickMarcEdit addFieldsItem(FieldItem fieldsItem) {
    super.addFieldsItem(fieldsItem);
    return this;
  }

  public QuickMarcEdit suppressDiscovery(Boolean suppressDiscovery) {
    super.suppressDiscovery(suppressDiscovery);
    return this;
  }

  public QuickMarcEdit marcFormat(MarcFormat marcFormat) {
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
    QuickMarcEdit quickMarcEdit = (QuickMarcEdit) o;
    return Objects.equals(this.parsedRecordId, quickMarcEdit.parsedRecordId) &&
        Objects.equals(this.parsedRecordDtoId, quickMarcEdit.parsedRecordDtoId) &&
        Objects.equals(this.externalId, quickMarcEdit.externalId) &&
        Objects.equals(this.externalHrid, quickMarcEdit.externalHrid) &&
        Objects.equals(this.relatedRecordVersion, quickMarcEdit.relatedRecordVersion) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parsedRecordId, parsedRecordDtoId, externalId, externalHrid, relatedRecordVersion, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuickMarcEdit {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    parsedRecordId: ").append(toIndentedString(parsedRecordId)).append("\n");
    sb.append("    parsedRecordDtoId: ").append(toIndentedString(parsedRecordDtoId)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    externalHrid: ").append(toIndentedString(externalHrid)).append("\n");
    sb.append("    relatedRecordVersion: ").append(toIndentedString(relatedRecordVersion)).append("\n");
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

