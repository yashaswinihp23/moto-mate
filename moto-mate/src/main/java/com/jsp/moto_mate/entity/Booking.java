package com.jsp.moto_mate.entity;

import com.jsp.moto_mate.dto.BookingDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String mobileNumber;

    private String bikeModel;

    private String regNumber;

    public Booking(BookingDto dto) {
        this.fullName = dto.getFullName();
        this.mobileNumber = dto.getMobileNumber();
        this.bikeModel = dto.getBikeModel();
        this.regNumber = dto.getRegNumber();
    }
}
