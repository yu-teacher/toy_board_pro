package board.project.serviceImpl;

import board.project.dto.BoardDTO;
import board.project.entity.Board;
import board.project.entity.BoardTag;
import board.project.entity.BoardUrl;
import board.project.repository.BoardLikeRepository;
import board.project.repository.BoardRepository;
import board.project.repository.BoardTagRepository;
import board.project.repository.BoardUrlRepository;
import board.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardUrlRepository boardUrlRepository;
    private final BoardTagRepository boardTagRepository;
    private final BoardLikeRepository boardLikeRepository;

    @Override
    public Long register(HashMap<Object, Object> params) {
        String title = params.get("title").toString();
        String content = params.get("content").toString();
        Long boardCase = Long.parseLong(params.get("boardCase").toString());

        Board board = Board
                .builder()
                .title(title)
                .content(content)
                .boardCase(boardCase)
                .build();

        Board createBoard = boardRepository.save(board);

        String boardUrl1 = params.get("url1").toString();
        String boardUrl2 = params.get("url2").toString();
        String boardUrl3 = params.get("url3").toString();
        String boardUrl4 = params.get("url4").toString();
        String boardUrl5 = params.get("url5").toString();

        BoardUrl boardUrl = BoardUrl
                .builder()
                .board(createBoard)
                .url1(boardUrl1)
                .url2(boardUrl2)
                .url3(boardUrl3)
                .url4(boardUrl4)
                .url5(boardUrl5)
                .build();

        boardUrlRepository.save(boardUrl);

        String tag1 = params.get("tag1").toString();
        String tag2 = params.get("tag2").toString();
        String tag3 = params.get("tag3").toString();

        BoardTag boardTag = BoardTag
                .builder()
                .board(createBoard)
                .tag1(tag1)
                .tag2(tag2)
                .tag3(tag3)
                .build();

        boardTagRepository.save(boardTag);

        return createBoard.getBoardNum();
    }

    @Override
    public Long update(HashMap<Object, Object> params) {
        Long boardNum = Long.parseLong(params.get("boardNum").toString());
        String title = params.get("title").toString();
        String content = params.get("content").toString();
        Long boardCase = Long.parseLong(params.get("boardCase").toString());

        Optional<Board> result = boardRepository.findById(boardNum);
        Board updateBoard = new Board();

        if(result.isPresent()){
            Board board = result.get();

            board = Board
                    .builder()
                    .title(title)
                    .content(content)
                    .boardCase(boardCase)
                    .build();

            updateBoard = boardRepository.save(board);
        }

        String boardUrl1 = params.get("url1").toString();
        String boardUrl2 = params.get("url2").toString();
        String boardUrl3 = params.get("url3").toString();
        String boardUrl4 = params.get("url4").toString();
        String boardUrl5 = params.get("url5").toString();

        BoardUrl boardUrl = BoardUrl
                .builder()
                .board(updateBoard)
                .url1(boardUrl1)
                .url2(boardUrl2)
                .url3(boardUrl3)
                .url4(boardUrl4)
                .url5(boardUrl5)
                .build();

        boardUrlRepository.save(boardUrl);

        String tag1 = params.get("tag1").toString();
        String tag2 = params.get("tag2").toString();
        String tag3 = params.get("tag3").toString();

        BoardTag boardTag = BoardTag
                .builder()
                .board(updateBoard)
                .tag1(tag1)
                .tag2(tag2)
                .tag3(tag3)
                .build();

        boardTagRepository.save(boardTag);

        return updateBoard.getBoardNum();
    }

    @Override
    public List<BoardDTO> getList(Pageable pageable) {
        return null;
    }

    @Override
    public BoardDTO read(Long boardNum) {
        return null;
    }

    @Override
    public void delete(Long boardNum) {
        boardRepository.deleteById(boardNum);
    }
}
