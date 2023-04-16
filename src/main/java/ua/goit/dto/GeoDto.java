package ua.goit.dto;

import java.util.Objects;

public record GeoDto(double lat, double lng) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoDto geoDto = (GeoDto) o;
        return Objects.equals(lat, geoDto.lat) && Objects.equals(lng, geoDto.lng);
    }

    @Override
    public String toString() {
        return "GeoDto{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
