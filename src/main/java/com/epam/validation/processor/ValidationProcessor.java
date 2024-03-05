package com.epam.validation.processor;

import com.epam.validation.domain.Field;
import com.epam.validation.domain.RuleSet;
import com.epam.validation.domain.ValidationResult;
import com.epam.validation.marc.dto.BaseMarcRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationProcessor {
    private static String SELECTOR_MATCHER = "(ANY|LDR|[0-9]{3})([0-9]{2})?\\$?([a-z])?";

    private Field selectorToField(String selector) {
        var tag = "";
        String ind1 = null;
        String ind2 = null;
        String subfield;
        Pattern pattern = Pattern.compile(SELECTOR_MATCHER);
        Matcher matcher = pattern.matcher(selector);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("not consistent with pattern " + SELECTOR_MATCHER);
        }
        tag = matcher.group(1);
        var indicatorString = matcher.group(2);
        if (indicatorString != null) {
            ind1 = indicatorString.substring(0, 1);
            ind2 = indicatorString.substring(1, 1);
        }
        subfield = matcher.group(3);

        return new Field(tag, ind1, ind2, subfield);
    }

    public List<ValidationResult> process(BaseMarcRecord record, RuleSet rules) {
        return rules.getRules().stream().map(rule -> rule.getValidations().stream()
                        .map(v -> {
                            v.setRuleId(rule.getId());
                            return v.validate(record, selectorToField(rule.getFieldSelector()));
                        })
                        .toList()).flatMap(List::stream)
                .filter(ValidationResult::isError)
                .toList();
    }


}

