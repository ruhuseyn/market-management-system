package com.backend101.marketmanagementsystem.exception;

import java.time.LocalDateTime;

public record Errors(

        LocalDateTime localDateTime,
        String message,
        String details
) {
}
