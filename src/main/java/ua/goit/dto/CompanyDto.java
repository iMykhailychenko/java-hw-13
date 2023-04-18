package ua.goit.dto;

public record CompanyDto(String name, String catchPhrase, String bs) {
    @Override
    public String toString() {
        return "CompanyDto{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
