package ua.goit.dto;

public record GeoDto(double lat, double lng) {
    @Override
    public String toString() {
        return "GeoDto{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
