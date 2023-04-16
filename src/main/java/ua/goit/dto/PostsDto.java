package ua.goit.dto;

public record PostsDto(int userId, int id, String title, String body) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostsDto postsDto)) return false;
        return userId == postsDto.userId && id == postsDto.id && title.equals(postsDto.title) && body.equals(postsDto.body);
    }

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
