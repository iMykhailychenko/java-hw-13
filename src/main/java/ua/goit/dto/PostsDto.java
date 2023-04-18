package ua.goit.dto;

public record PostsDto(int userId, int id, String title, String body) {
    @Override
    public String toString() {
        return "PostsDto{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
