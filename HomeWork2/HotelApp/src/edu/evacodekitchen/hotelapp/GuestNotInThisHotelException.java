package edu.evacodekitchen.hotelapp;

public class GuestNotInThisHotelException extends RuntimeException {
	public GuestNotInThisHotelException(String message) {
		super(message);
	}
}
