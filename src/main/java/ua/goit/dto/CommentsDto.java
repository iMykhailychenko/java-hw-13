package ua.goit.dto;

public record CommentsDto(int postId, int id, String name, String email, String body) {
    @Override
    public String toString() {
        return "\n------------------\nname: " + name + "\n\nbody: " + body;
    }
}
