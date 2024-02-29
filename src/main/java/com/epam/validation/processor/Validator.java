package com.epam.validation.processor;

import com.epam.validation.domain.ValidationResult;
import com.epam.validation.domain.ValidationRule;
import com.epam.validation.marc.dto.BaseMarcRecord;
import com.epam.validation.marc.dto.FieldItem;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Validator {

    String SELECTOR_MATCHER = "([0-9]{3})([0-9]{2})?\\$?([a-z])?";
    // "65010$a
    String SUBFIELD_CHAR = "$";

    ValidationResult validate(BaseMarcRecord record, ValidationRule rule);

    default List<FieldItem> fieldsByFieldSelector(BaseMarcRecord record, List<String> fieldSelectors) {
        return fieldSelectors.stream().map(fieldSelector -> {
            var tag = "";
            var ind1 = "";
            var ind2 = "";
            var subfield = "";
            Pattern selector = Pattern.compile(SELECTOR_MATCHER);
            Matcher matcher = selector.matcher(fieldSelector);
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

            final var t = tag;
            final var i1 = ind1;
            final var i2 = ind2;
            final var sf = subfield;

            return record.getFields().stream()
                    .filter(fieldItem -> {
                        if (!fieldItem.getTag().equals(t)) {
                            return false;
                        }
                        if (!StringUtils.isEmpty(i1) && !StringUtils.isEmpty(i2)) {
                            var indicators = fieldItem.getIndicators();
                            if (indicators == null || indicators.isEmpty()) {
                                return false;
                            }
                            if (indicators.size() != 2) {
                                return false;
                            }
                            if (!indicators.get(0).equals(i1) || !indicators.get(1).equals(i2)) {
                                return false;
                            }
                        }

                        return StringUtils.isEmpty(sf) || ((String) fieldItem.getContent()).contains(SUBFIELD_CHAR + sf);
                    }).toList();

        }).flatMap(Collection::stream).toList();


    }
}
