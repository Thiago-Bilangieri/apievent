package com.bilanevent.api.domain.event;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

public record EventRequestDTO(
                              String title,
                              String description,
                              Long date,
                              String city,
                              String state,
                              Boolean remote,
                              String eventUrl,
                              MultipartFile image) {
}
