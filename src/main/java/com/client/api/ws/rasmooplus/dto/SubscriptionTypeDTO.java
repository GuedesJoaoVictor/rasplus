package com.client.api.ws.rasmooplus.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionTypeDTO {
    private Long id;
    @NotBlank(message = "Cant be null or empty")
    @Size(min = 5, max = 30)
    private String name;
    @Max(value = 12, message = "Access Month cant be more than 12")
    private Long accessMonth;
    @NotBlank(message = "Cant be null or empty")
    private BigDecimal price;
    @Size(min = 5, max = 15)
    private String productKey;
}
