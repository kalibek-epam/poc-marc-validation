package com.epam.validation.domain.validation;

import com.epam.validation.domain.MarcValidation;
import com.epam.validation.domain.ValidationResult;
import com.epam.validation.marc.dto.FieldItem;
import lombok.Data;

import java.util.List;

@Data
public class AllowedValues extends MarcValidation {

    private int position;
    private List<String> values;


    @Override
    public ValidationResult validate(List<FieldItem> fieldItems) {
        if (fieldItems.size() != 1 || fieldItems.get(0).getContent() == null) {
            return ValidationResult.error(getRuleId(), "Should have only 1 field");
        }
        String content = fieldItems.get(0).getContent().toString();
        if (values.contains(content.substring(position - 1, position))) {
            return ValidationResult.ok();
        }
        return ValidationResult.error(getRuleId(), String.format("Should have %s at position %d",
                String.join(", ", values),
                position
        ));
    }
}
