package baemin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "member") // 명시하지않으면 클래스명 기본값으로 사용
@Table(name = "member") // table명 명시
@DynamicInsert // INSERT시 NULL TRUE 컬럼은 추가 안시키기 -> 기본값이 들어감
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseTimeEntity {

    @Id //pk
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(name = "active_yn")
    private String activeYn;

    @Column(nullable = false)
    private String name;

    @LastModifiedDate
    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false, name = "order_count_agree_yn")
    private String orderCountAgreeYn;

    @Column
    private String grade;

    @Column
    private String address;

    @LastModifiedDate
    @Column(name = "last_change_password_date")
    private LocalDateTime lastChangePasswordDate;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_origin_name")
    private String fileOriginalName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_size")
    private String fileSize;

    @Column(name = "file_type")
    private String fileType;

    @Column(nullable = false, name = "foreigner_yn")
    private String foreignerYn;

    @Column(nullable = false, name = "personal_info_agree_yn")
    private String personalInfoAgreeYn;

    @Column(nullable = false, name = "third_party_agree_yn")
    private String thirdPartyAgreeYn;

    @Column(nullable = false, name = "marketing_receive_agree_yn")
    private String marketingReceiveAgreeYn;

}
