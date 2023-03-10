package board.project.service;

import board.project.dto.BoardDTO;
import board.project.entity.Board;
import board.project.entity.Member;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
    /** 게시물 등록하기 */
    Long register(HashMap<Object, Object> params);
    /** 게시물 수정하기 */
    Long update(HashMap<Object,Object> params);
    /** 게시물 리스트 불러오기 */
    List<BoardDTO> getList(Pageable pageable);
    /** 게시물 읽기 */
    BoardDTO read(Long boardNum);
    /** 게시물 삭제 */
    void delete(Long boardNum);

    default Board boardDTE(BoardDTO boardDTO, Member member){
        Board board = Board
                .builder()
                .boardNum(boardDTO.getBoardNum() == null ? null : boardDTO.getBoardNum())
                .member(member)
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .boardCase(boardDTO.getBoardCase())
                .viewCount(boardDTO.getViewCount())
                .likeCount(boardDTO.getLikeCount())
                .commentCount(boardDTO.getCommentCount())
                .build();

        return board;
    }


}
