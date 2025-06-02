package hellojpa;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "INSERT_MEMBER")
    private String createBy;
    private LocalDateTime createDateTime;

    @Column(name = "UPDATE_MEMBER")
    private String lastModifyBy;
    private LocalDateTime lastModifyDateTime;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    public LocalDateTime getLastModifyDateTime() {
        return lastModifyDateTime;
    }

    public void setLastModifyDateTime(LocalDateTime lastModifyDateTime) {
        this.lastModifyDateTime = lastModifyDateTime;
    }
}
