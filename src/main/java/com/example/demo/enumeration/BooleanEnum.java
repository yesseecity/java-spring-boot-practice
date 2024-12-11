package com.example.demo.enumeration;

public enum BooleanEnum {
        Y("Y"), 
        N("N");

        private final String value;

        BooleanEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
}