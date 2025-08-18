package com.jsp.moto_mate.service;

import com.jsp.moto_mate.entity.Booking;

public interface BookingService {
    Booking saveBooking(Booking booking);
    Booking getBookingById(Long id);
}



// package com.jsp.moto_mate.service;

// import com.jsp.moto_mate.entity.Booking;
// import com.jsp.moto_mate.repository.BookingRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;

// import java.io.File;
// import java.io.IOException;

// @Service
// public class BookingService {

//     @Autowired
//     private BookingRepository bookingRepository;

//     public Booking saveBooking(Booking booking) throws IOException {
//         // Handle the uploaded photo
//         MultipartFile photo = booking.getPhoto();
//         if (photo != null && !photo.isEmpty()) {
//             String uploadDir = "uploads/";
//             String photoPath = uploadDir + System.currentTimeMillis() + "_" + photo.getOriginalFilename();
//             File dest = new File(photoPath);
//             dest.getParentFile().mkdirs(); // ensure upload directory exists
//             photo.transferTo(dest);
//             booking.setPhotoPath(photoPath);
//         }

//         return bookingRepository.save(booking);
//     }

//     public Booking getBookingById(Long id) {
//         return bookingRepository.findById(id).orElse(null);
//     }
// }
