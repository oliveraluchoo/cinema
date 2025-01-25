package com.exampleproject.MovieReservationSystem.dto;

public class BookingDTO {

    private Long screeningId;
    private Integer numberOfSeats;
    private String customerName;
    public Long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer amount) {
        this.numberOfSeats = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
