package example.mini2_erd;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * 모든 엔티티 공통 : 생성/수정 시각 자동 관리.
 * 컬럼명은 create_date / update_date (mini2.sql 기준).
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class BaseTime {

    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime updateDate;
}
