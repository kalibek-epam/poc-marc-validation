package com.epam.validation.processor.impl;

import com.epam.validation.domain.ValidationRuleSet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

public abstract class AbstractValidationTest {
    @Getter
    private ValidationRuleSet ruleSet;
    private ObjectMapper mapper = new ObjectMapper();

    public void parseRules(String json) {
        try {
            ruleSet = mapper.readValue(json, ValidationRuleSet.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
