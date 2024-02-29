package com.epam.validation.mapper.validation;

import com.epam.validation.domain.ValidationResult;
import com.epam.validation.mapper.MarcValidation;
import com.epam.validation.marc.dto.FieldItem;
import lombok.Data;

import java.util.List;

@Data
public class SubfieldExactlyOne extends MarcValidation {
    private static final String SUBFIELD_CHAR = "$";
    private String subfield;

    @Override
    public ValidationResult validate(List<FieldItem> fieldItems) {
        List<String> subfieldValues = fieldItems.stream()
                .filter(f -> f.getContent().toString().contains(SUBFIELD_CHAR + subfield))
                .map()
        return null;
    }
}
