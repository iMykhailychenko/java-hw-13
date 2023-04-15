package ua.goit.dto;

import java.util.Objects;

public record AddressDto(String street, String suite, String city, String zipcode, GeoDto geo) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(street, that.street) && Objects.equals(suite, that.suite) && Objects.equals(city, that.city) && Objects.equals(zipcode, that.zipcode) && Objects.equals(geo, that.geo);
    }

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
