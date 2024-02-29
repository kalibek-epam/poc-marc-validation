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
                OnlyOneFieldValidator.class
        }
)
class OnlyOneFieldValidatorTest extends AbstractValidationTest {

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
                      "operation": "ONLY_ONE_FIELD",
                      "format": "MARC",
                      "fieldSelectors": [
                        "100",
                        "101"
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
        FieldItem f102 = new FieldItem();
        f102.setTag("102");
        QuickMarcCreate rec = new QuickMarcCreate()
                .fields(List.of(f100, f102));


        List<ValidationError> validate = processor.validate(rec, this.getRuleSet());

        assertThat(validate).hasSize(0);

    }

    @Test
    void shouldReturnError() {
        FieldItem f100 = new FieldItem();
        f100.setTag("100");
        QuickMarcCreate rec = new QuickMarcCreate()
                .fields(List.of(f100, f100));


        List<ValidationError> validate = processor.validate(rec, this.getRuleSet());

        assertThat(validate).hasSize(1);

    }

}