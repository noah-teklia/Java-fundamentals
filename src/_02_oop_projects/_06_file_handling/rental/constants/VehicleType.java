package _02_oop_projects._06_file_handling.rental.constants;

public enum VehicleType {
    CAR,
    TRUCK,
    MOTORCYCLE,
    BUS,
    BICYCLE;

    public static VehicleType fromString(String value) {
        return VehicleType.valueOf(value.toUpperCase());
    }
}
