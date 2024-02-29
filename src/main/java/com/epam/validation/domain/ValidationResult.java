package com.epam.validation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationResult {
    private boolean isError;
    private ValidationError error;

    public static ValidationResult ok() {
        return new ValidationResult();
    }

    public static ValidationResult error(String message) {
        return new ValidationResult(true, new ValidationError(message));
    }
}
