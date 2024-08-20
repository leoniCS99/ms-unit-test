package org.acme.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConverterUtils {
    public static final String CONVERTER_REGEX = "\\(\\d{2}\\)9\\d{4}\\d{4}";
}
