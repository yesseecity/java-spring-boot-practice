package com.example.demo.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooleanEnumConverter implements AttributeConverter<BooleanEnum, String> {

    @Override
    public String convertToDatabaseColumn(BooleanEnum attribute) {
        return attribute.getValue();
    }

    @Override
    public BooleanEnum convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "Y":
                return BooleanEnum.Y;
            case "N":
                return BooleanEnum.N;
            default:
                throw new IllegalArgumentException("Unknown value: " + dbData);
        }
    }
}