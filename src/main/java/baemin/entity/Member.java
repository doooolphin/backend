package baemin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="member") // table명 명시
public class Member {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql , autoincrement
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;
}
