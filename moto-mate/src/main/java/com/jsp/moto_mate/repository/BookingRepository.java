package com.jsp.moto_mate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.moto_mate.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

