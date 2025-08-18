package com.jsp.moto_mate.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.moto_mate.dto.BookingConfirmDto;
import com.jsp.moto_mate.dto.BookingDto;
import com.jsp.moto_mate.dto.LoginDto;
import com.jsp.moto_mate.dto.ScheduleFormDto;
import com.jsp.moto_mate.dto.ServiceSelectionDto;
import com.jsp.moto_mate.dto.UserDto;
import com.jsp.moto_mate.dto.WorkshopDto;
import com.jsp.moto_mate.entity.Booking;
import com.jsp.moto_mate.entity.BookingConfirmation;
import com.jsp.moto_mate.entity.ScheduleForm;
import com.jsp.moto_mate.entity.ServiceSelection;
import com.jsp.moto_mate.entity.User;
import com.jsp.moto_mate.repository.BookingConfirmationRepository;
import com.jsp.moto_mate.repository.BookingRepository;
import com.jsp.moto_mate.repository.ScheduleFormRepository;
import com.jsp.moto_mate.repository.ServiceSelectionRepository;
import com.jsp.moto_mate.repository.UserRepository;
import com.jsp.moto_mate.service.OtpService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProjectController {

    private final UserRepository userRepository;
    private final OtpService otpService;

    @GetMapping("/")
    public String loadHome() {
        return "home.html";
    }

    @GetMapping("/register")
    public String loadRegister(UserDto userDto, ModelMap map) {
        map.put("userDto", userDto);
        return "register.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid UserDto userDto, BindingResult result, HttpSession session) {
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "error.confirmPassword",
                    "* Password and ConfirmPassword should be Matching");
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            result.rejectValue("email", "error.email",
                    "* Email Should be unique");
        }
        if (userRepository.existsByMobile(userDto.getMobile())) {
            result.rejectValue("mobile", "error.mobile",
                    "* Mobile Should be unique");
        }
        if (result.hasErrors()) {
            return "register.html";
        } else {
            int otp = new Random().nextInt(1000, 10000);
//            otpService.sendEmailOtp(userDto.getEmail(), otp);
//            otpService.sendMobileOtp(userDto.getMobile(), otp);
            // Send OTP based on user choice (email or mobile)
            if (userDto.getEmail() != null && !userDto.getEmail().isEmpty()) {
                otpService.sendEmailOtp(userDto.getEmail(), otp);
            }
            if (userDto.getMobile() != null && userDto.getMobile() > 0) {
                otpService.sendMobileOtp(userDto.getMobile(), otp);
            }

            session.setAttribute("otp", otp);
            session.setAttribute("userDto", userDto);
            return "redirect:/otp";
        }
    }

    @GetMapping("/otp")
    public String showOtpPage() {
        return "otp.html";
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam int otp, HttpSession session) {
        int sessionOtp = (int) session.getAttribute("otp");
        System.out.println("Otp : " + otp + " " + sessionOtp);
        if (otp == sessionOtp) {
            UserDto userDto = (UserDto) session.getAttribute("userDto");
            User user = new User(userDto);
            userRepository.save(user);
            session.removeAttribute("otp");
            session.removeAttribute("userDto");
            session.setAttribute("pass", "Account registered Success");
            return "redirect:/login";
        } else {
            session.setAttribute("fail", "Invalid OTP. Please try again.");
            return "redirect:/otp";
        }
    }

    //otpController.java
//    @RequestMapping("/otp")
//        @PostMapping("/send")
//        public ResponseEntity<String> sendOtp(@RequestParam String email) {
//            int otp = (int) (Math.random() * 9000) + 1000; // Generate 4-digit OTP
//            otpService.sendOtp(email, otp);
//
//            return ResponseEntity.ok("OTP sent to email: " + email);
//        }
//    
    @GetMapping("/login")
    public String showLoginPage(Model model
    ) {
        model.addAttribute("loginDto", new LoginDto());
        return "login.html";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginDto")
            @Valid LoginDto loginDto,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {
            return "login";
        }

        User user = userRepository.findByEmail(loginDto.getEmail());

        if (user == null || !user.getPassword().equals(loginDto.getPassword())) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }

        return "redirect:/service";
    }

    //2ND PAGE BOOKING PAGE
    @Autowired
    private BookingRepository bookingRepository;  // Add this at the top

    @GetMapping("/service")
    public String showServicePage(Model model
    ) {
        model.addAttribute("booking", new BookingDto());
        return "service";
    }

// @PostMapping("/service")
// public String processBooking(@Valid @ModelAttribute("booking") BookingDto bookingDto,
//                              BindingResult result, Model model) {
//     if (result.hasErrors()) {
//         return "service";
//     }
//     // Save to DB
//     Booking booking = new Booking(bookingDto);
//     bookingRepository.save(booking);
//     // You can pass booking ID to next page using session, or model if needed
//     return "redirect:/select-service";
// }
    @PostMapping("/service")
    public String saveBikeDetails(@ModelAttribute BookingDto bookingDto, Model model
    ) {
        Booking booking = new Booking(bookingDto);
        bookingRepository.save(booking);

        // Add booking ID to model or session to use in next page
        model.addAttribute("bookingId", booking.getId());

        return "redirect:/select-service";
    }

//3rd page- select service page
    @Autowired
    private ServiceSelectionRepository serviceSelectionRepository;

    @GetMapping("/select-service")
    public String showServiceSelectionForm(Model model
    ) {
        model.addAttribute("serviceSelection", new ServiceSelectionDto());
        return "select-service";
    }

    // @PostMapping("/select-service")
    // public String processServiceForm(@Valid @ModelAttribute ServiceSelectionDto serviceSelection,
    //                              BindingResult result, Model model) {
    //     if (result.hasErrors()) {
    //         return "select-service";
    //     }
//     @GetMapping("/select-service")
// public String showServiceForm(Model model) {
//     model.addAttribute("serviceSelection", new ServiceSelectionDto());
//     return "select-service";
// }
// @PostMapping("/select-service")
// public String processServiceSelection(@ModelAttribute("serviceSelection") ServiceSelectionDto serviceSelectionDto) {
//     // Save to DB or session (your logic here)
//     System.out.println("Selected Services: " + serviceSelectionDto.getServiceTypes());
//     return "redirect:/schedule-service"; // Next page
// }
    //     int total = 0;
    //     for (String s : serviceSelection.getSelectedServices()) {
    //         switch (s) {
    //             case "General Service" -> total += 499;
    //             case "Engine Work" -> total += 1299;
    //             case "Oil Change" -> total += 299;
    //             case "Brake Service" -> total += 699;
    //         }
    //     }
    //     serviceSelection.setEstimatedCost(total);
    //     model.addAttribute("serviceSelection", serviceSelection);
    //     return "redirect:/schedule";
    // }
    @PostMapping("/select-service")
    public String handleServiceSelection(@ModelAttribute("serviceSelection") ServiceSelectionDto dto
    ) {
        int estimatedCost = 0;
        for (String service : dto.getSelectedServices()) {
            switch (service) {
                case "General Service" ->
                    estimatedCost += 499;
                case "Engine Work" ->
                    estimatedCost += 1299;
                case "Oil Change" ->
                    estimatedCost += 299;
                case "Brake Service" ->
                    estimatedCost += 699;
                case "Other Service" ->
                    estimatedCost += 200;
            }
        }

        // Create Entity object and save
        ServiceSelection entity = new ServiceSelection();
        entity.setSelectedServices(dto.getSelectedServices());
        entity.setEstimatedCost(estimatedCost);
        serviceSelectionRepository.save(entity);

        // Optional: pass data using RedirectAttributes
        return "redirect:/schedule";
    }

//4th page schedule
    @Autowired
    private ScheduleFormRepository scheduleRepo;

    @GetMapping("/schedule")
    public String showScheduleForm(Model model
    ) {
        model.addAttribute("scheduleForm", new ScheduleFormDto());
        return "schedule";
    }

//    @PostMapping("/schedule")
//    public String submitScheduleForm(
//            @Valid
//            @ModelAttribute("scheduleForm") ScheduleFormDto form,
//            BindingResult result,
//            Model model
//    ) {
//
//        if (result.hasErrors()) {
//            return "schedule";
//        }
//
//        // Map DTO to Entity
//        ScheduleForm entity = new ScheduleForm();
//        entity.setPreferredDate(form.getPreferredDate());
//        entity.setTimeSlot(form.getTimeSlot());
//        entity.setPickupOption(form.getPickupOption());
//        entity.setNotes(form.getNotes());
//
//        // Optional: store photo file names
//        if (form.getPhotos() != null && form.getPhotos().length > 0) {
//            StringBuilder photoNames = new StringBuilder();
//            for (var photo : form.getPhotos()) {
//                photoNames.append(photo.getOriginalFilename()).append(", ");
//                // Save photo to file system if needed
//            }
//            entity.setPhotoNames(photoNames.toString());
//        }
//
//        // Save to DB
//        scheduleRepo.save(entity);
//
//        return "redirect:/confirmation";
//    }
    
    //altered code for postmapping schedule
    
    @PostMapping("/schedule")
    public String submitScheduleForm(
            @Valid @ModelAttribute("scheduleForm") ScheduleFormDto form,
            BindingResult result,
            Model model,
            HttpSession session
    ) {
        if (result.hasErrors()) {
            return "schedule";
        }

        // Save ScheduleForm
        ScheduleForm entity = new ScheduleForm();
        entity.setPreferredDate(form.getPreferredDate());
        entity.setTimeSlot(form.getTimeSlot());
        entity.setPickupOption(form.getPickupOption());
        entity.setNotes(form.getNotes());
        scheduleRepo.save(entity);

        // Put data into session for confirmation
        BookingConfirmDto bookingDto = new BookingConfirmDto();
        bookingDto.setDate(form.getPreferredDate());
        bookingDto.setTimeSlot(form.getTimeSlot());
        bookingDto.setDeliveryMethod(form.getPickupOption());
        session.setAttribute("booking", bookingDto);

        String bookingId = "SM" + new Random().nextInt(999999);
        session.setAttribute("bookingId", bookingId);

        return "redirect:/confirmation"; // will now have data
    }


//5th page - confirmation page
    @Autowired
    private BookingConfirmationRepository bookingConfirmationRepository;

    @PostMapping("/confirmation")
    public String showConfirmation(@ModelAttribute BookingConfirmDto bookingDto, Model model
    ) {
        // Generate booking ID
        String bookingId = "SM" + new Random().nextInt(999999);

        // Save to DB
        BookingConfirmation booking = new BookingConfirmation();
        booking.setBookingId(bookingId);
        booking.setServices(bookingDto.getServices());
        booking.setBikeModel(bookingDto.getBikeModel());
        booking.setRegistrationNumber(bookingDto.getRegistrationNumber());
        booking.setDate(bookingDto.getDate());
        booking.setTimeSlot(bookingDto.getTimeSlot());
        booking.setDeliveryMethod(bookingDto.getDeliveryMethod());

        bookingConfirmationRepository.save(booking);

        // Pass to view
        model.addAttribute("bookingId", bookingId);
        model.addAttribute("booking", bookingDto);

        // Workshop info
        WorkshopDto workshop = new WorkshopDto();
        workshop.setName("Supreme Motors");
        workshop.setAddress("123 Main Street, Business District");
        workshop.setReviews("240+");
        workshop.setPhone("+91 XXXX XXX XXX");
        workshop.setHours("Open 9AM–7PM Mon–Sat");

        model.addAttribute("workshop", workshop);

        return "confirmation";
    }

    // GET - after redirect
    @GetMapping("/confirmation")
    public String getConfirmationPage(HttpSession session, Model model
    ) {
        BookingConfirmDto booking = (BookingConfirmDto) session.getAttribute("booking");
        String bookingId = (String) session.getAttribute("bookingId");

        if (booking == null || bookingId == null) {
            return "redirect:/"; // if no booking data, go home or back
        }

        model.addAttribute("booking", booking);
        model.addAttribute("bookingId", bookingId);
        model.addAttribute("workshopName", "Supreme Motors Workshop");
        model.addAttribute("address", "123 Main Street, Business District");
        model.addAttribute("phone", "+91 XXXXX XXXXX");
        model.addAttribute("hours", "Open 9AM–7PM Mon-Sat");
        model.addAttribute("reviews", 240);

        return "confirmation";
    }
}
