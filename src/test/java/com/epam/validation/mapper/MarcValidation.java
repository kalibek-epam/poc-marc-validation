package com.epam.validation.mapper;


import com.epam.validation.domain.ValidationResult;
import com.epam.validation.mapper.validation.*;
import com.epam.validation.marc.dto.BaseMarcRecord;
import com.epam.validation.marc.dto.FieldItem;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AllowedValues.class, name = "ALLOWED_VALUES"),
        @JsonSubTypes.Type(value = Length.class, name = "LENGTH"),
        @JsonSubTypes.Type(value = NonRepeatable.class, name = "NON_REPEATABLE"),
        @JsonSubTypes.Type(value = NotEmpty.class, name = "NOT_EMPTY"),
        @JsonSubTypes.Type(value = Required.class, name = "REQUIRED"),
        @JsonSubTypes.Type(value = SubfieldExactlyOne.class, name = "SUBFIELD_EXACTLY_ONE")
})
@Data
public abstract class MarcValidation {
    private static final String SELECTOR_MATCHER = "([0-9]{3})([0-9]{2})?\\$?([a-z])?";
    private static final String SUBFIELD_CHAR = "$";

    private Field dependsOn;
    private MarcFieldType fieldType;

    private List<FieldItem> fieldsByFieldSelector(BaseMarcRecord record, Field field) {

        return record.getFields().stream()
                .filter(fieldItem -> {
                    if (!fieldItem.getTag().equals(field.getTag())) {
                        return false;
                    }
                    if (!StringUtils.isEmpty(field.getInd1()) && !StringUtils.isEmpty(field.getInd2())) {
                        var indicators = fieldItem.getIndicators();
                        if (indicators == null || indicators.isEmpty()) {
                            return false;
                        }
                        if (indicators.size() != 2) {
                            return false;
                        }
                        if (!indicators.get(0).equals(field.getInd1())
                                || !indicators.get(1).equals(field.getInd2())) {
                            return false;
                        }
                    }

                    return StringUtils.isEmpty(field.getSubfield())
                            || ((String) fieldItem.getContent()).contains(SUBFIELD_CHAR + field.getSubfield());
                }).toList();


    }

    public ValidationResult validate(BaseMarcRecord record, Field field) {
        if (dependsOn != null) {
            List<FieldItem> fieldItems = fieldsByFieldSelector(record, dependsOn);
            if (!fieldItems.isEmpty()) {
                return ValidationResult.ok();
            }
        }
        return validate(fieldsByFieldSelector(record, field));
    }

    public abstract ValidationResult validate(List<FieldItem> fieldItems);
}
