package com.epam.validation.processor.impl;

import com.epam.validation.domain.*;
import com.epam.validation.marc.dto.BaseMarcRecord;
import com.epam.validation.processor.Validator;
import org.springframework.stereotype.Component;

@Rule(
        format = SupportedFormat.MARC,
        operation = Operation.LEADER_ALLOWED_VALUES
)
@Component
public class LeaderAllowedValuesValidator implements Validator {
    @Override
    public ValidationResult validate(BaseMarcRecord record, ValidationRule rule) {
        var pos = Integer.parseInt(rule.getFieldSelectors().get(0));
        var leader = record.getLeader();
        var value = leader.substring(pos, pos + 1);
        if (!rule.getValues().contains(value)) {
            return ValidationResult.error(new ValidationError(rule.getTitle(), "failed"));
        }
        return ValidationResult.ok();

    }
}
