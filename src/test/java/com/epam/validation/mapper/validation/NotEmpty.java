package com.epam.validation.mapper.validation;

import com.epam.validation.domain.ValidationResult;
import com.epam.validation.mapper.MarcValidation;
import com.epam.validation.marc.dto.FieldItem;

import java.util.List;

public class NotEmpty extends MarcValidation {
    @Override
    public ValidationResult validate(List<FieldItem> fieldItems) {
        return fieldItems.isEmpty() ?
                ValidationResult.error("field is empty") :
                ValidationResult.ok();
    }
}
