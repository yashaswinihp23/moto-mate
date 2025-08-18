package com.jsp.moto_mate.dto;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ScheduleFormDto {

    @NotNull(message = "Please select a date")
    private LocalDate preferredDate;

    @NotEmpty(message = "Please select a time slot")
    private String timeSlot;

    @NotEmpty(message = "Please choose a pickup option")
    private String pickupOption;

    private String notes;
    private MultipartFile[] photos;
}







