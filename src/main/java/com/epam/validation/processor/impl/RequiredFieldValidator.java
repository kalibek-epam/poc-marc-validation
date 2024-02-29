package com.epam.validation.processor.impl;

import com.epam.validation.domain.*;
import com.epam.validation.marc.dto.BaseMarcRecord;
import com.epam.validation.processor.Validator;
import org.springframework.stereotype.Component;

@Rule(
        format = SupportedFormat.MARC,
        operation = Operation.REQUIRED
)
@Component
public class RequiredFieldValidator implements Validator {
    @Override
    public ValidationResult validate(BaseMarcRecord record, ValidationRule rule) {
        long count = fieldsByFieldSelector(record, rule.getFieldSelectors()).size();
        if (count != 1) {
            return ValidationResult.error(new ValidationError(rule.getTitle(), "failed"));
        }
        return ValidationResult.ok();
    }
}
