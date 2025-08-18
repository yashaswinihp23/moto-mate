package com.jsp.moto_mate.dto;

import java.time.LocalDate;

public class BookingConfirmDto {
    private String services;
    private String bikeModel;
    private String registrationNumber;
    private String date;
    private String timeSlot;
    private String deliveryMethod;

    // Getters and setters
    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }

    public String getBikeModel() { return bikeModel; }
    public void setBikeModel(String bikeModel) { this.bikeModel = bikeModel; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

    public String getDeliveryMethod() { return deliveryMethod; }
    public void setDeliveryMethod(String deliveryMethod) { this.deliveryMethod = deliveryMethod; }
	public void setDate(LocalDate preferredDate) {
		// TODO Auto-generated method stub
		
	}
}


// public class BookingConfirmDto {

//     private String services;
//     private String bikeModel;
//     private String registrationNumber;
//     private String date;
//     private String timeSlot;
//     private String deliveryMethod;

//     // Getters and Setters
//     public String getServices() {
//         return services;
//     }

//     public void setServices(String services) {
//         this.services = services;
//     }

//     public String getBikeModel() {
//         return bikeModel;
//     }

//     public void setBikeModel(String bikeModel) {
//         this.bikeModel = bikeModel;
//     }

//     public String getRegistrationNumber() {
//         return registrationNumber;
//     }

//     public void setRegistrationNumber(String registrationNumber) {
//         this.registrationNumber = registrationNumber;
//     }

//     public String getDate() {
//         return date;
//     }

//     public void setDate(String date) {
//         this.date = date;
//     }

//     public String getTimeSlot() {
//         return timeSlot;
//     }

//     public void setTimeSlot(String timeSlot) {
//         this.timeSlot = timeSlot;
//     }

//     public String getDeliveryMethod() {
//         return deliveryMethod;
//     }

//     public void setDeliveryMethod(String deliveryMethod) {
//         this.deliveryMethod = deliveryMethod;
//     }
// }

// import java.util.List;

// public class BookingConfirmDto {

//     private String bookingId;
//     private String bikeModel;
//     private String registrationNumber;
//     private List<String> selectedServices;
//     private String preferredDate;
//     private String timeSlot;
//     private String deliveryMethod;

//     // Default constructor
//     public BookingConfirmDto() {
//     }

//     // All-args constructor
//     public BookingConfirmDto(String bookingId, String bikeModel, String registrationNumber, List<String> selectedServices,
//                              String preferredDate, String timeSlot, String deliveryMethod) {
//         this.bookingId = bookingId;
//         this.bikeModel = bikeModel;
//         this.registrationNumber = registrationNumber;
//         this.selectedServices = selectedServices;
//         this.preferredDate = preferredDate;
//         this.timeSlot = timeSlot;
//         this.deliveryMethod = deliveryMethod;
//     }

//     // Getters and Setters

//     public String getBookingId() {
//         return bookingId;
//     }

//     public void setBookingId(String bookingId) {
//         this.bookingId = bookingId;
//     }

//     public String getBikeModel() {
//         return bikeModel;
//     }

//     public void setBikeModel(String bikeModel) {
//         this.bikeModel = bikeModel;
//     }

//     public String getRegistrationNumber() {
//         return registrationNumber;
//     }

//     public void setRegistrationNumber(String registrationNumber) {
//         this.registrationNumber = registrationNumber;
//     }

//     public List<String> getSelectedServices() {
//         return selectedServices;
//     }

//     public void setSelectedServices(List<String> selectedServices) {
//         this.selectedServices = selectedServices;
//     }

//     public String getPreferredDate() {
//         return preferredDate;
//     }

//     public void setPreferredDate(String preferredDate) {
//         this.preferredDate = preferredDate;
//     }

//     public String getTimeSlot() {
//         return timeSlot;
//     }

//     public void setTimeSlot(String timeSlot) {
//         this.timeSlot = timeSlot;
//     }

//     public String getDeliveryMethod() {
//         return deliveryMethod;
//     }

//     public void setDeliveryMethod(String deliveryMethod) {
//         this.deliveryMethod = deliveryMethod;
//     }
// }




// package com.jsp.moto_mate.dto;

// public class BookingConfirmDto {

//     private String bookingId;
//     private String services;
//     private String bikeModel;
//     private String registrationNumber;
//     private String date;
//     private String timeSlot;
//     private String deliveryMethod;

//     // Constructors
//     public BookingConfirmDto() {}

//     public BookingConfirmDto(String bookingId, String services, String bikeModel, String registrationNumber, String date, String timeSlot, String deliveryMethod) {
//         this.bookingId = bookingId;
//         this.services = services;
//         this.bikeModel = bikeModel;
//         this.registrationNumber = registrationNumber;
//         this.date = date;
//         this.timeSlot = timeSlot;
//         this.deliveryMethod = deliveryMethod;
//     }

//     // Getters and Setters

//     public String getBookingId() {
//         return bookingId;
//     }

//     public void setBookingId(String bookingId) {
//         this.bookingId = bookingId;
//     }

//     public String getServices() {
//         return services;
//     }

//     public void setServices(String services) {
//         this.services = services;
//     }

//     public String getBikeModel() {
//         return bikeModel;
//     }

//     public void setBikeModel(String bikeModel) {
//         this.bikeModel = bikeModel;
//     }

//     public String getRegistrationNumber() {
//         return registrationNumber;
//     }

//     public void setRegistrationNumber(String registrationNumber) {
//         this.registrationNumber = registrationNumber;
//     }

//     public String getDate() {
//         return date;
//     }

//     public void setDate(String date) {
//         this.date = date;
//     }

//     public String getTimeSlot() {
//         return timeSlot;
//     }

//     public void setTimeSlot(String timeSlot) {
//         this.timeSlot = timeSlot;
//     }

//     public String getDeliveryMethod() {
//         return deliveryMethod;
//     }

//     public void setDeliveryMethod(String deliveryMethod) {
//         this.deliveryMethod = deliveryMethod;
//     }
// }

