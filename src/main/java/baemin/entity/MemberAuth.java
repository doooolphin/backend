package baemin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "member_auth")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class MemberAuth extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name="auth_key")
    private String authKey;
}
