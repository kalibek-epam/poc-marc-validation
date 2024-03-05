package com.epam.validation.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MarcRule.class, name = "MARC"),
})
@Data
public abstract class Rule {
    private String id;
    private String fieldSelector;
    private String fieldType;
    private Level level;
    private List<MarcValidation> validations;
}
