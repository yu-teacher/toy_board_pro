package board.project.entity;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Table(indexes = {@Index(name = "member_index",columnList = "id")})			//맴버에 인덱스 추가
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;
    @Column(length =100, nullable = false, unique = true)
    private String id;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 100, nullable = false, unique = true)
    private String nickname;
    @Column(length = 200)
    private String url;
    @Column(length = 300)
    private String email;

}
