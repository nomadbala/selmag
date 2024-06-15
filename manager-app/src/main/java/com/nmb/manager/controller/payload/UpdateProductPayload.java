package com.nmb.manager.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateProductPayload(
        @NotNull(message = "{catalogue.products.update.errors.title_null}")
        @Size(min = 3, max = 50, message = "{catalogue.products.update.errors.title_size_invalid}")
        String title,

        @Size(max = 1000, message = "{catalogue.products.update.errors.details_size_invalid}")
        String details
) {
}