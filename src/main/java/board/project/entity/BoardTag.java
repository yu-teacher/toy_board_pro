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
public class BoardTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardTagNum;
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
    @Column(length = 100)
    private String tag1;
    @Column(length = 100)
    private String tag2;
    @Column(length = 100)
    private String tag3;
}
