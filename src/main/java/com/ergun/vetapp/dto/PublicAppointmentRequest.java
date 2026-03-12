package com.ergun.vetapp.dto;

public class PublicAppointmentRequest {
    private String petName;
    private String petType;
    private String dateTime;
    private String reason;

    public String getPetName() { return petName; }
    public void setPetName(String petName) { this.petName = petName; }
    public String getPetType() { return petType; }
    public void setPetType(String petType) { this.petType = petType; }
    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}