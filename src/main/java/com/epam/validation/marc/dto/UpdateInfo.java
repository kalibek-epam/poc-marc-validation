package com.epam.validation.marc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Record metadata
 */

@Schema(name = "updateInfo", description = "Record metadata")
@JsonTypeName("updateInfo")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-11T18:27:36.277406700+06:00[Asia/Almaty]")
public class UpdateInfo {

  private RecordState recordState;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updateDate;

  private UserInfo updatedBy;

  public UpdateInfo recordState(RecordState recordState) {
    this.recordState = recordState;
    return this;
  }

  /**
   * Get recordState
   * @return recordState
  */
  @Valid 
  @Schema(name = "recordState", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recordState")
  public RecordState getRecordState() {
    return recordState;
  }

  public void setRecordState(RecordState recordState) {
    this.recordState = recordState;
  }

  public UpdateInfo updateDate(OffsetDateTime updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  /**
   * Date and time of last successful update of the record
   * @return updateDate
  */
  @Valid 
  @Schema(name = "updateDate", description = "Date and time of last successful update of the record", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updateDate")
  public OffsetDateTime getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(OffsetDateTime updateDate) {
    this.updateDate = updateDate;
  }

  public UpdateInfo updatedBy(UserInfo updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  /**
   * Get updatedBy
   * @return updatedBy
  */
  @Valid 
  @Schema(name = "updatedBy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedBy")
  public UserInfo getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(UserInfo updatedBy) {
    this.updatedBy = updatedBy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateInfo updateInfo = (UpdateInfo) o;
    return Objects.equals(this.recordState, updateInfo.recordState) &&
        Objects.equals(this.updateDate, updateInfo.updateDate) &&
        Objects.equals(this.updatedBy, updateInfo.updatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recordState, updateDate, updatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateInfo {\n");
    sb.append("    recordState: ").append(toIndentedString(recordState)).append("\n");
    sb.append("    updateDate: ").append(toIndentedString(updateDate)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
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

