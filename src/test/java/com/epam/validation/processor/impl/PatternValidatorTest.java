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
                PatternValidator.class
        }
)
class PatternValidatorTest extends AbstractValidationTest {

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
                      "operation": "PATTERN_MATCH",
                      "format": "MARC",
                      "fieldSelectors": [
                        "10001"
                      ],
                      "values": [
                        "[a-z]+"
                      ]
                    }
                  ]
                }
                """);
    }

    @Test
    void shouldReturnNoErrors() {
        FieldItem f100 = new FieldItem();
        f100.setTag("100");
        f100.setIndicators(List.of("0", "1"));
        f100.setContent("shouldpass");
        QuickMarcCreate rec = new QuickMarcCreate()
                .fields(List.of(f100));


        List<ValidationError> validate = processor.validate(rec, this.getRuleSet());

        assertThat(validate).hasSize(0);

    }

    @Test
    void shouldReturnError() {
        FieldItem f100 = new FieldItem();
        f100.setTag("100");
        f100.setIndicators(List.of("0", "1"));
        f100.setContent("should fail");
        QuickMarcCreate rec = new QuickMarcCreate()
                .fields(List.of(f100));


        List<ValidationError> validate = processor.validate(rec, this.getRuleSet());

        assertThat(validate).hasSize(1);

    }
}