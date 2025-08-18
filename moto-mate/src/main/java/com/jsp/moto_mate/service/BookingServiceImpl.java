package com.jsp.moto_mate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsp.moto_mate.entity.Booking;
import com.jsp.moto_mate.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
}



// package com.jsp.moto_mate.service;



// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.jsp.moto_mate.entity.Booking;
// import com.jsp.moto_mate.repository.BookingRepository;

// @Service
// public class BookingServiceImpl implements BookingService {

//     @Autowired
//     private BookingRepository bookingRepository;

//     @Override
//     public Booking saveBooking(Booking booking) {
//         return bookingRepository.save(booking);
//     }
// }

