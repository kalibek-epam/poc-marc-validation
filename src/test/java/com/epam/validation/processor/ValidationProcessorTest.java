package com.epam.validation.processor;

import com.epam.validation.domain.RuleSet;
import com.epam.validation.domain.ValidationResult;
import com.epam.validation.marc.dto.BaseMarcRecord;
import com.epam.validation.marc.dto.FieldItem;
import com.epam.validation.marc.dto.QuickMarcEdit;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationProcessorTest {
    private RuleSet ruleSet;
    private ValidationProcessor processor = new ValidationProcessor();

    @BeforeEach
    void setup() throws IOException {
        var objectMapper = new ObjectMapper();
        File file = FileUtils.getFile("src", "test", "resources", "rules.json");
        System.out.println(file.getAbsolutePath());
        ruleSet = objectMapper.readValue(file, RuleSet.class);

    }

    @Test
    void process_whenAllowedValuesArePresent_ShouldReturnNoErrors() {
        var fields = List.of(
                withField("001", "test"),
                withField("010", "$a test"),
                withField("101", "test")
        );
        BaseMarcRecord record = new QuickMarcEdit();
        record.setLeader("0000a0000000000000000000");
        record.fields(fields);

        List<ValidationResult> results = processor.process(record, ruleSet);

        assertThat(results).hasSize(0);
    }

    private FieldItem withField(String tag, String content) {
        var f = new FieldItem()
                .tag(tag);
        f.setContent(content);
        return f;
    }


}