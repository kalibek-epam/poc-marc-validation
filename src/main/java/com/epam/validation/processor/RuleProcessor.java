package com.epam.validation.processor;

import com.epam.validation.domain.Rule;
import com.epam.validation.domain.ValidationError;
import com.epam.validation.domain.ValidationResult;
import com.epam.validation.domain.ValidationRuleSet;
import com.epam.validation.marc.dto.BaseMarcRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RuleProcessor {

    private final ApplicationContext ctx;

    public List<ValidationError> validate(BaseMarcRecord record, ValidationRuleSet rules) {
        return rules.getRules().stream()
                .map(r -> ctx.getBeansWithAnnotation(Rule.class).entrySet().stream()
                        .filter(entry -> {
                            Rule annotation = entry.getValue().getClass().getAnnotation(Rule.class);
                            return annotation.format() == r.getFormat()
                                    && Objects.equals(annotation.operation(), r.getOperation());
                        }).findFirst()
                        .map(entry -> ((Validator) entry.getValue()).validate(record, r))
                        .orElse(ValidationResult.ok())
                )
                .filter(ValidationResult::isError)
                .map(ValidationResult::getError)
                .toList();

    }
}
