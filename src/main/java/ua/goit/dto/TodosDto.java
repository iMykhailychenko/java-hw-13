package ua.goit.dto;

public record TodosDto(int userId, int id, String title, boolean completed) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodosDto todosDto)) return false;
        return userId == todosDto.userId && id == todosDto.id && completed == todosDto.completed && title.equals(todosDto.title);
    }

    @Override
    public String toString() {
        return "\n------------------\nid: " + id + "\ntitle: " + title;
    }
}
