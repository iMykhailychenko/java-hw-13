package ua.goit.dto;

public record UserDto(int id, String name, String username, String phone, String website,
                      String email, AddressDto address, CompanyDto company) {
    @Override
    public String toString() {
        return "UserDto{" +
                "\n id=" + id +
                ",\n name='" + name + '\'' +
                ",\n username='" + username + '\'' +
                ",\n phone='" + phone + '\'' +
                ",\n website='" + website + '\'' +
                ",\n email='" + email + '\'' +
                ",\n address=" + address +
                ",\n company=" + company +
                "\n}";
    }
}
