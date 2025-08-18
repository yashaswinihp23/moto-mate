package com.jsp.moto_mate.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ScheduleForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate preferredDate;

    private String timeSlot;

    private String pickupOption;

    @Column(length = 1000)
    private String notes;

    // Optional: if you want to store filenames or paths of uploaded photos
    private String photoNames;
}
