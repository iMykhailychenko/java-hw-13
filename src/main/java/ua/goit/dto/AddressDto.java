package ua.goit.dto;

public record AddressDto(String street, String suite, String city, String zipcode, GeoDto geo) {
    @Override
    public String toString() {
        return "AddressDto{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
