package com.nmb.managerapp.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewProductPayload(
        @NotNull(message = "{catalogue.products.create.errors.title_null}")
        @Size(min = 3, max = 50, message = "{catalogue.products.create.errors.title_size_invalid}")
        String title,

        @Size(max = 1000, message = "{catalogue.products.create.errors.details_size_invalid}")
        String details
) {
}
