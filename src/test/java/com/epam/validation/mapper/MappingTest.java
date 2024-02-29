package com.epam.validation.mapper;

import com.epam.validation.mapper.validation.SubfieldExactlyOne;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class MappingTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();

    }

    @Test
    void test() throws IOException {
        File file = FileUtils.getFile("src", "test", "resources", "rules.json");
        System.out.println(file.getAbsolutePath());
        RuleSet ruleSet = objectMapper.readValue(file, RuleSet.class);

        MarcValidation marcValidation = ruleSet.getRules().stream()
                .filter(r -> r.getValidations().stream()
                        .anyMatch(v -> v.getClass().equals(SubfieldExactlyOne.class)))
                .map(r -> r.getValidations().stream()
                        .filter(v -> v.getClass().equals(SubfieldExactlyOne.class))
                        .findFirst().orElseThrow()
                ).findFirst().orElseThrow();
        assertThat(marcValidation).hasFieldOrProperty("subfield");
    }
}
