package com.meetingroom.booking.model;

public class AvailabilityResponse{

  private boolean available;

  public AvailabilityResponse(boolean available){
    this.available = available;
  }

  public void setAvailable(boolean available){
    this.available = available;
  }

  public boolean isAvailable(){
    return available;
  }

}