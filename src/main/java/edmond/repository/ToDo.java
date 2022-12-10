package edmond.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ToDo implements Serializable {
    private int id;
    private String username;

    private String description;
    private boolean done;

    private LocalDate targetDate;

    public ToDo(int id, String username, String description, boolean done, LocalDate targetDate) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.done = done;
        this.targetDate = targetDate;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDone() {
        return this.done;
    }

    public LocalDate getTargetDate() {
        return this.targetDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof final ToDo other)) return false;
        if (!other.canEqual(this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (!Objects.equals(this$username, other$username)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (!Objects.equals(this$description, other$description))
            return false;
        if (this.isDone() != other.isDone()) return false;
        final Object this$targetDate = this.getTargetDate();
        final Object other$targetDate = other.getTargetDate();
        return Objects.equals(this$targetDate, other$targetDate);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ToDo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        result = result * PRIME + (this.isDone() ? 79 : 97);
        final Object $targetDate = this.getTargetDate();
        result = result * PRIME + ($targetDate == null ? 43 : $targetDate.hashCode());
        return result;
    }

    public String toString() {
        return "ToDo(id=" + this.getId() + ", username=" + this.getUsername() + ", description=" + this.getDescription() + ", done=" + this.isDone() + ", targetDate=" + this.getTargetDate() + ")";
    }
}
