package com.epam.validation.domain;

import lombok.Data;

import java.util.List;

@Data
public class ValidationRule {
    // TODO: Hiararchical structure

    private String title;
    private Operation operation;
    private SupportedFormat format;
    private List<String> fieldSelectors;
    private List<String> values;
}