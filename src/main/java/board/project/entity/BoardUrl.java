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
public class BoardUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardUrlNum;
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
    @Column(length = 100)
    private String url1;
    @Column(length = 100)
    private String url2;
    @Column(length = 100)
    private String url3;
    @Column(length = 100)
    private String url4;
    @Column(length = 100)
    private String url5;

}
