package com.epam.validation.domain.validation;

import com.epam.validation.domain.MarcValidation;
import com.epam.validation.domain.ValidationResult;
import com.epam.validation.marc.dto.FieldItem;
import lombok.Data;

import java.util.List;

@Data
public class Length extends MarcValidation {
    private int length;

    @Override
    public ValidationResult validate(List<FieldItem> fieldItems) {
        for (FieldItem f : fieldItems) {
            if (f.getContent() == null || f.getContent().toString().length() != length) {
                return ValidationResult.error(getRuleId(), String.format("Should have length %d", length));
            }
        }
        return ValidationResult.ok();
    }
}
