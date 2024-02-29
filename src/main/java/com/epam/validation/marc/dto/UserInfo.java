package com.epam.validation.marc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;
import java.util.UUID;

/**
 * User Display Information
 */

@Schema(name = "userInfo", description = "User Display Information")
@JsonTypeName("userInfo")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-11T18:27:36.277406700+06:00[Asia/Almaty]")
public class UserInfo {

  private UUID userId;

  private String username;

  private String lastName;

  private String firstName;

  private String middleName;

  public UserInfo userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @Valid 
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public UserInfo username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Username of the user
   * @return username
  */
  
  @Schema(name = "username", accessMode = Schema.AccessMode.READ_ONLY, description = "Username of the user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserInfo lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the user
   * @return lastName
  */
  
  @Schema(name = "lastName", accessMode = Schema.AccessMode.READ_ONLY, description = "Last name of the user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserInfo firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the user
   * @return firstName
  */
  
  @Schema(name = "firstName", accessMode = Schema.AccessMode.READ_ONLY, description = "First name of the user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserInfo middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Middle name or initial of the user
   * @return middleName
  */
  
  @Schema(name = "middleName", accessMode = Schema.AccessMode.READ_ONLY, description = "Middle name or initial of the user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("middleName")
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo userInfo = (UserInfo) o;
    return Objects.equals(this.userId, userInfo.userId) &&
        Objects.equals(this.username, userInfo.username) &&
        Objects.equals(this.lastName, userInfo.lastName) &&
        Objects.equals(this.firstName, userInfo.firstName) &&
        Objects.equals(this.middleName, userInfo.middleName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, username, lastName, firstName, middleName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
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

