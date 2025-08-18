package com.jsp.moto_mate.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class ServiceSelectionDto {


    @NotEmpty(message = "Select at least one service")
    private List<String> selectedServices;

    // Optional - cost summary (can be computed server-side)
    private int estimatedCost;

    // Getters and Setters
    public List<String> getSelectedServices() {
        return selectedServices;
    }

    public void setSelectedServices(List<String> selectedServices) {
        this.selectedServices = selectedServices;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(int estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}

