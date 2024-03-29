package com.epam.validation.domain.validation;

import com.epam.validation.domain.MarcValidation;
import com.epam.validation.domain.ValidationResult;
import com.epam.validation.marc.dto.FieldItem;

import java.util.List;

public class NonRepeatable extends MarcValidation {
    @Override
    public ValidationResult validate(List<FieldItem> fieldItems) {
        return fieldItems.size() != 1 ?
                ValidationResult.error(getRuleId(), "field is empty") :
                ValidationResult.ok();

    }
}
