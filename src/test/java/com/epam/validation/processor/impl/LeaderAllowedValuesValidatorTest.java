package com.epam.validation.processor.impl;

import com.epam.validation.domain.ValidationError;
import com.epam.validation.marc.dto.FieldItem;
import com.epam.validation.marc.dto.QuickMarcCreate;
import com.epam.validation.processor.RuleProcessor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import(
        value = {
                RuleProcessor.class,
                LeaderAllowedValuesValidator.class
        }
)
class LeaderAllowedValuesValidatorTest extends AbstractValidationTest {

    @Autowired
    private RuleProcessor processor;

    @BeforeEach
    @SneakyThrows
    void setup() {
        parseRules("""
                {
                  "rules": [
                    {
                      "title": "only one 1XX field",
                      "operation": "LEADER_ALLOWED_VALUES",
                      "format": "MARC",
                      "fieldSelectors": [
                        "8"
                      ],
                      "values": [
                        "a", "b", "c"
                      ]
                    }
                  ]
                }
                """);
    }

    @Test
    void shouldReturnNoErrors() {
        QuickMarcCreate rec = new QuickMarcCreate()
                .leader("00000000a000");

        List<ValidationError> validate = processor.validate(rec, this.getRuleSet());

        assertThat(validate).hasSize(0);

    }

    @Test
    void shouldReturnError() {

        QuickMarcCreate rec = new QuickMarcCreate()
                .leader("00000000x000");



        List<ValidationError> validate = processor.validate(rec, this.getRuleSet());

        assertThat(validate).hasSize(1);

    }
}