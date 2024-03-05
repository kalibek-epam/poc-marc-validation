package com.epam.validation.domain.validation;

import com.epam.validation.domain.MarcValidation;
import com.epam.validation.domain.ValidationResult;
import com.epam.validation.marc.dto.FieldItem;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class SubfieldExactlyOne extends MarcValidation {
    private static final String SUBFIELD_CHAR = "$";
    private String subfield;

    @Override
    public ValidationResult validate(List<FieldItem> fieldItems) {
        try {

            if (fieldItems.stream()
                    .filter(f -> {
                        String content = f.getContent().toString();
                        Map<String, String> subfields = new HashMap<>();
                        Pattern pattern = Pattern.compile("\\$([a-z0-9]) ([^$]+)");
                        Matcher matcher = pattern.matcher(content);
                        while (matcher.find()) {
                            if (matcher.group(1) != null && matcher.group(2) != null) {
                                if (subfields.putIfAbsent(matcher.group(1), matcher.group(2)) != null) {
                                    throw new RuntimeException("subfield repeated");
                                }
                            }
                        }
                        return !subfields.get(subfield).isEmpty();
                    }).toList().size() != 1) {
                return ValidationResult.error(getRuleId(), "Subfield is not unique");
            }
            return ValidationResult.ok();

        } catch (Exception e) {
            return ValidationResult.error(getRuleId(), "Subfield is not unique");
        }
    }
}
