package com.epam.validation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Field {
    private String tag;
    private String ind1 ;
    private String ind2;
    private String subfield;
}
