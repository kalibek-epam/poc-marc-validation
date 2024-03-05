package com.epam.validation.domain;

import lombok.Data;

import java.util.Set;

@Data
public class RuleSet {

    private Set<Rule> rules;
}
