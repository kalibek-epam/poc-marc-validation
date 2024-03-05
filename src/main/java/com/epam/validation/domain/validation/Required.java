package com.epam.validation.domain.validation;

import com.epam.validation.domain.MarcValidation;
import com.epam.validation.domain.ValidationResult;
import com.epam.validation.marc.dto.FieldItem;

import java.util.List;

public class Required extends MarcValidation {
    @Override
    public ValidationResult validate(List<FieldItem> fieldItems) {
        return fieldItems.isEmpty() ?
                ValidationResult.error(getRuleId(), "field is not present") :
                ValidationResult.ok();
    }
}
