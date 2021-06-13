package edu.evacodekitchen.hotelapp;

import java.util.*;

public class Hotel {

	private List<RoomType> roomTypes;
	private List<Bicycle> bicyles;
	private List<Guest> guests;

	public Hotel(List<RoomType> roomTypes, List<Bicycle> bicyles) {
		this.roomTypes = roomTypes;
		this.bicyles = bicyles;
		guests = new ArrayList<>();
	}

	public void addGuest(Guest guest) {
		guests.add(guest);
	}

	public int calculateFinalPrice(Guest guest) {
		int finalPrice = 0;
		
		if (!guests.contains(guest)) {
			throw new GuestNotInThisHotelException("Megadott vendég nem tartózkodik a hotelben!");
		}
		
		Bicycle bicycle = guest.getRentedBicyle();
		if (bicycle != null) {
			int nrOfDaysToRentTheBicycle = guest.getNrOfDaysToRentTheBicycle();
			finalPrice = bicycle.getPricePerDay() * nrOfDaysToRentTheBicycle;			
		}
		
		RoomType rentedRoomType = guest.getRentedRoomType();
		int nrOfDaysToRentTheRoom = guest.getNrOfDaysToRentTheRoom();
		finalPrice += rentedRoomType.getPricePerDay() * nrOfDaysToRentTheRoom;
		
		return finalPrice;
	}

}
