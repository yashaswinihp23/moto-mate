// package com.jsp.moto_mate.controller;

// //import java.io.IOException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.jsp.moto_mate.entity.Booking;
// import com.jsp.moto_mate.service.BookingService;

// @Controller
// public class BookingController {

//     @Autowired
//     private BookingService bookingService;

//     @PostMapping("/submitBooking")
//     public String submitBooking(@ModelAttribute Booking booking, Model model) {
//         Booking savedBooking = bookingService.saveBooking(booking);
//         model.addAttribute("booking", savedBooking);
//         return "booking-confirmation";
//     }

//     @GetMapping("/booking/{id}")
//     public String getBooking(@PathVariable Long id, Model model) {
//         Booking booking = bookingService.getBookingById(id);
//         model.addAttribute("booking", booking);
//         return "booking-confirmation";
//     }
// }