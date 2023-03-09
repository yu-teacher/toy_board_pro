package board.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long boardNum;
    private String title;
    private String content;
    private Long viewCount;
    private Long likeCount;
    private Long commentCount;
    private Long boardCase;
    private String nickName;
}
