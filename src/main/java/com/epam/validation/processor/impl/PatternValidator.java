package com.epam.validation.processor.impl;

import com.epam.validation.domain.*;
import com.epam.validation.marc.dto.BaseMarcRecord;
import com.epam.validation.processor.Validator;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Rule(
        format = SupportedFormat.MARC,
        operation = Operation.PATTERN_MATCH
)
@Component
public class PatternValidator implements Validator {
    @Override
    public ValidationResult validate(BaseMarcRecord record, ValidationRule rule) {
        var fields = fieldsByFieldSelector(record, rule.getFieldSelectors());
        Pattern pattern = Pattern.compile(rule.getValues().get(0));
        for (var field : fields) {
            Matcher matcher = pattern.matcher((String) field.getContent());
            if (!matcher.matches()) {
                return ValidationResult.error(new ValidationError(rule.getTitle(), "failed"));
            }
        }
        return ValidationResult.ok();
    }
}
