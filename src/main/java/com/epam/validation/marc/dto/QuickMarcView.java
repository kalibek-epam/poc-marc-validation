package com.epam.validation.marc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * QuickMarcView
 */


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-11T18:27:36.277406700+06:00[Asia/Almaty]")
public class QuickMarcView extends BaseMarcRecord {

  private UUID parsedRecordId;

  private UUID parsedRecordDtoId;

  private UUID externalId;

  private String externalHrid;

  private UpdateInfo updateInfo;

  public QuickMarcView parsedRecordId(UUID parsedRecordId) {
    this.parsedRecordId = parsedRecordId;
    return this;
  }

  /**
   * Get parsedRecordId
   * @return parsedRecordId
  */
  @Valid 
  @Schema(name = "parsedRecordId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parsedRecordId")
  public UUID getParsedRecordId() {
    return parsedRecordId;
  }

  public void setParsedRecordId(UUID parsedRecordId) {
    this.parsedRecordId = parsedRecordId;
  }

  public QuickMarcView parsedRecordDtoId(UUID parsedRecordDtoId) {
    this.parsedRecordDtoId = parsedRecordDtoId;
    return this;
  }

  /**
   * Get parsedRecordDtoId
   * @return parsedRecordDtoId
  */
  @Valid 
  @Schema(name = "parsedRecordDtoId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parsedRecordDtoId")
  public UUID getParsedRecordDtoId() {
    return parsedRecordDtoId;
  }

  public void setParsedRecordDtoId(UUID parsedRecordDtoId) {
    this.parsedRecordDtoId = parsedRecordDtoId;
  }

  public QuickMarcView externalId(UUID externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * Get externalId
   * @return externalId
  */
  @Valid 
  @Schema(name = "externalId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("externalId")
  public UUID getExternalId() {
    return externalId;
  }

  public void setExternalId(UUID externalId) {
    this.externalId = externalId;
  }

  public QuickMarcView externalHrid(String externalHrid) {
    this.externalHrid = externalHrid;
    return this;
  }

  /**
   * HRID of external entity
   * @return externalHrid
  */
  
  @Schema(name = "externalHrid", description = "HRID of external entity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("externalHrid")
  public String getExternalHrid() {
    return externalHrid;
  }

  public void setExternalHrid(String externalHrid) {
    this.externalHrid = externalHrid;
  }

  public QuickMarcView updateInfo(UpdateInfo updateInfo) {
    this.updateInfo = updateInfo;
    return this;
  }

  /**
   * Get updateInfo
   * @return updateInfo
  */
  @Valid 
  @Schema(name = "updateInfo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updateInfo")
  public UpdateInfo getUpdateInfo() {
    return updateInfo;
  }

  public void setUpdateInfo(UpdateInfo updateInfo) {
    this.updateInfo = updateInfo;
  }


  public QuickMarcView leader(String leader) {
    super.leader(leader);
    return this;
  }

  public QuickMarcView fields(List<@Valid FieldItem> fields) {
    super.fields(fields);
    return this;
  }

  public QuickMarcView addFieldsItem(FieldItem fieldsItem) {
    super.addFieldsItem(fieldsItem);
    return this;
  }

  public QuickMarcView suppressDiscovery(Boolean suppressDiscovery) {
    super.suppressDiscovery(suppressDiscovery);
    return this;
  }

  public QuickMarcView marcFormat(MarcFormat marcFormat) {
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
    QuickMarcView quickMarcView = (QuickMarcView) o;
    return Objects.equals(this.parsedRecordId, quickMarcView.parsedRecordId) &&
        Objects.equals(this.parsedRecordDtoId, quickMarcView.parsedRecordDtoId) &&
        Objects.equals(this.externalId, quickMarcView.externalId) &&
        Objects.equals(this.externalHrid, quickMarcView.externalHrid) &&
        Objects.equals(this.updateInfo, quickMarcView.updateInfo) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parsedRecordId, parsedRecordDtoId, externalId, externalHrid, updateInfo, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuickMarcView {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    parsedRecordId: ").append(toIndentedString(parsedRecordId)).append("\n");
    sb.append("    parsedRecordDtoId: ").append(toIndentedString(parsedRecordDtoId)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    externalHrid: ").append(toIndentedString(externalHrid)).append("\n");
    sb.append("    updateInfo: ").append(toIndentedString(updateInfo)).append("\n");
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

