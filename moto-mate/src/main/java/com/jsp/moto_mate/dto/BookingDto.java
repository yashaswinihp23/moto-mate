package com.jsp.moto_mate.dto;

//import java.util.List;

//import org.springframework.web.multipart.MultipartFile;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class BookingDto {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Bike model is required")
    private String bikeModel;

    @NotBlank(message = "Registration number is required")
    private String regNumber;

    // @NotEmpty(message = "Please select at least one service type")
    // private String[] serviceTypes;

    // @NotEmpty(message = "Please select at least one service type")
    // private List<String> serviceTypes;



    // @NotBlank(message = "Preferred date is required")
    // private String preferredDate;

    // @NotBlank(message = "Time slot is required")
    // private String timeSlot;

    // @NotBlank(message = "Pickup option is required")
    // private String pickupOption;

    // private String additionalNotes;

    // private MultipartFile photo;


    // Getters and Setters

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    // public String[] getServiceTypes() {
    //     return serviceTypes;
    // }

    // public void setServiceTypes(String[] serviceTypes) {
    //     this.serviceTypes = serviceTypes;
    // }

    // public List<String> getServiceTypes() {
    //     return serviceTypes;
    // }

    // public void setServiceTypes(List<String> serviceTypes) {
    //     this.serviceTypes = serviceTypes;
    // }

    // public String getPreferredDate() {
    //     return preferredDate;
    // }

    // public void setPreferredDate(String preferredDate) {
    //     this.preferredDate = preferredDate;
    // }

    // public String getTimeSlot() {
    //     return timeSlot;
    // }

    // public void setTimeSlot(String timeSlot) {
    //     this.timeSlot = timeSlot;
    // }

    // public String getPickupOption() {
    //     return pickupOption;
    // }

    // public void setPickupOption(String pickupOption) {
    //     this.pickupOption = pickupOption;
    // }

    // public String getAdditionalNotes() {
    //     return additionalNotes;
    // }

    // public void setAdditionalNotes(String additionalNotes) {
    //     this.additionalNotes = additionalNotes;
    // }

    // public MultipartFile getPhoto() {
    //     return photo;
    // }

    // public void setPhoto(MultipartFile photo) {
    //     this.photo = photo;
    // }

    public String getRegistrationNumber() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
