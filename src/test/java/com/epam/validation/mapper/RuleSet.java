package com.epam.validation.mapper;

import lombok.Data;

import java.util.Set;

@Data
public class RuleSet {

    private Set<Rule> rules;
}
