package ua.goit.dto;

import java.util.Objects;

public record UserDto(int id, String name, String username, String phone, String website, String email,
                      AddressDto address, CompanyDto company) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto userDto)) return false;
        return id == userDto.id && Objects.equals(name, userDto.name) && Objects.equals(username, userDto.username) && Objects.equals(phone, userDto.phone) && Objects.equals(website, userDto.website) && Objects.equals(email, userDto.email) && Objects.equals(address, userDto.address) && Objects.equals(company, userDto.company);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", company=" + company +
                '}';
    }
}
