package ua.goit.dto;

public record TodosDto(int userId, int id, String title, boolean completed) {
    @Override
    public String toString() {
        return "\n------------------\nid: " + id + "\ntitle: " + title;
    }
}
