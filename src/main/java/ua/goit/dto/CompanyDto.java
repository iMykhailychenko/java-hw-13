package ua.goit.dto;

import java.util.Objects;

public record CompanyDto(String name, String catchPhrase, String bs) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDto that = (CompanyDto) o;
        return Objects.equals(name, that.name) && Objects.equals(catchPhrase, that.catchPhrase) && Objects.equals(bs, that.bs);
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
