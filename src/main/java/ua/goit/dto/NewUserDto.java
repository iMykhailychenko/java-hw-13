package ua.goit.dto;

import java.util.Objects;

public record NewUserDto(String name, String username, String phone, String website,
                         String email, AddressDto address, CompanyDto company) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewUserDto userDto)) return false;
        return Objects.equals(name, userDto.name) && Objects.equals(username, userDto.username) && Objects.equals(phone, userDto.phone) && Objects.equals(website, userDto.website) && Objects.equals(email, userDto.email) && Objects.equals(address, userDto.address) && Objects.equals(company, userDto.company);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "\n name='" + name + '\'' +
                ",\n username='" + username + '\'' +
                ",\n phone='" + phone + '\'' +
                ",\n website='" + website + '\'' +
                ",\n email='" + email + '\'' +
                ",\n address=" + address +
                ",\n company=" + company +
                "\n}";
    }
}
