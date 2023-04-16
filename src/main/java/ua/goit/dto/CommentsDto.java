package ua.goit.dto;

public record CommentsDto(int postId, int id, String name, String email, String body) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentsDto that)) return false;
        return postId == that.postId && id == that.id && name.equals(that.name) && email.equals(that.email) && body.equals(that.body);
    }

    @Override
    public String toString() {
        return "CommentsDto{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
