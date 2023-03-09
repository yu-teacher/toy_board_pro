package board.project.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNum;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 5000, nullable = false)
    private String content;
    @ColumnDefault("0")
    private Long viewCount;
    @ColumnDefault("0")
    private Long likeCount;
    @ColumnDefault("0")
    private Long commentCount;
    private Long boardCase;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

}
