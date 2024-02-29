package com.epam.validation.marc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.UUID;

/**
 * Link-related fields
 */

@Schema(name = "linkDetails", description = "Link-related fields")
@JsonTypeName("linkDetails")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-11T18:27:36.277406700+06:00[Asia/Almaty]")
public class LinkDetails {

  private UUID authorityId;

  private String authorityNaturalId;

  private Integer linkingRuleId;

  private String status;

  private String errorCause;

  public LinkDetails authorityId(UUID authorityId) {
    this.authorityId = authorityId;
    return this;
  }

  /**
   * Get authorityId
   * @return authorityId
  */
  @NotNull @Valid 
  @Schema(name = "authorityId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("authorityId")
  public UUID getAuthorityId() {
    return authorityId;
  }

  public void setAuthorityId(UUID authorityId) {
    this.authorityId = authorityId;
  }

  public LinkDetails authorityNaturalId(String authorityNaturalId) {
    this.authorityNaturalId = authorityNaturalId;
    return this;
  }

  /**
   * Natural id of the authority that controls subfields
   * @return authorityNaturalId
  */
  @NotNull 
  @Schema(name = "authorityNaturalId", example = "n1234567890", description = "Natural id of the authority that controls subfields", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("authorityNaturalId")
  public String getAuthorityNaturalId() {
    return authorityNaturalId;
  }

  public void setAuthorityNaturalId(String authorityNaturalId) {
    this.authorityNaturalId = authorityNaturalId;
  }

  public LinkDetails linkingRuleId(Integer linkingRuleId) {
    this.linkingRuleId = linkingRuleId;
    return this;
  }

  /**
   * Linking rule ID by which the link was created
   * @return linkingRuleId
  */
  @NotNull 
  @Schema(name = "linkingRuleId", example = "1", description = "Linking rule ID by which the link was created", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("linkingRuleId")
  public Integer getLinkingRuleId() {
    return linkingRuleId;
  }

  public void setLinkingRuleId(Integer linkingRuleId) {
    this.linkingRuleId = linkingRuleId;
  }

  public LinkDetails status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Link status
   * @return status
  */
  
  @Schema(name = "status", accessMode = Schema.AccessMode.READ_ONLY, example = "ACTUAL", description = "Link status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LinkDetails errorCause(String errorCause) {
    this.errorCause = errorCause;
    return this;
  }

  /**
   * Cause of error status
   * @return errorCause
  */
  
  @Schema(name = "errorCause", accessMode = Schema.AccessMode.READ_ONLY, example = "Optimistic locking", description = "Cause of error status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorCause")
  public String getErrorCause() {
    return errorCause;
  }

  public void setErrorCause(String errorCause) {
    this.errorCause = errorCause;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkDetails linkDetails = (LinkDetails) o;
    return Objects.equals(this.authorityId, linkDetails.authorityId) &&
        Objects.equals(this.authorityNaturalId, linkDetails.authorityNaturalId) &&
        Objects.equals(this.linkingRuleId, linkDetails.linkingRuleId) &&
        Objects.equals(this.status, linkDetails.status) &&
        Objects.equals(this.errorCause, linkDetails.errorCause);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authorityId, authorityNaturalId, linkingRuleId, status, errorCause);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkDetails {\n");
    sb.append("    authorityId: ").append(toIndentedString(authorityId)).append("\n");
    sb.append("    authorityNaturalId: ").append(toIndentedString(authorityNaturalId)).append("\n");
    sb.append("    linkingRuleId: ").append(toIndentedString(linkingRuleId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errorCause: ").append(toIndentedString(errorCause)).append("\n");
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

