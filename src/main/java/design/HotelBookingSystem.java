package design;

import java.util.Date;
import java.util.*;

public class HotelBookingSystem {

    // Enum : RoomStatus, RoomType, PaymentStatus, Facility
    // Class : User, Room, Hotel, Booking, Address, Duration, Facilities

    enum RoomStatus {
        EMPTY,
        NOT_EMPTY;
    }

    enum RoomType {
        SINGLE,
        DOUBLE,
        TRIPLE;
    }

    enum PaymentStatus {
        PAID,
        UNPAID;
    }

    enum Facility {
        LIFT,
        POWER_BACKUP,
        HOT_WATER,
        BREAKFAST_FREE,
        SWIMMING_POOL;
    }

    class User {
        int userId;
        String name;
        Date dateOfBirth;
        String mobNo;
        String emailId;
        String sex;
    }

    class Room {
        int roomId; // roomNo
        int hotelId;
        RoomType roomType;
        RoomStatus roomStatus;
    }

    class Hotel {
        int hotelId;
        String hotelName;
        Address address;
        List<Room> rooms;
        float rating;
        Facilities facilities;
    }

    class Booking {
        int bookingId;
        int userId;
        int hotelId;
        List<Room> bookedRooms;
        int amount;
        PaymentStatus status_of_payment;
        Date bookingTime;
        Duration duration;
    }

    class Address {
        String city;
        String pinCode;
        String state;
        String streetNo;
        String landmark;
    }

    class Duration {
        Date from;
        Date to;
    }

    class Facilities {
        List<Facility> facilitiesList;
    }
}
