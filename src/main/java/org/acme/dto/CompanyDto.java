package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Setter;
import org.acme.utils.ConverterUtils;

public record CompanyDto(
    @Setter(AccessLevel.NONE)
    Long id,
    @NotBlank(message = "name is required")
    String name,
    @NotBlank(message = "address is required")
    String address,
    @NotBlank(message = "registry is required")
    String registry,
    @NotBlank(message = "registry is required")
    @Pattern(regexp = ConverterUtils.CONVERTER_REGEX,
            message = "Celular inválido, o formato deve ser (XX) 9XXXX-XXXX")
    String phone) {
}
