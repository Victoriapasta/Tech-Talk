package toyproject.techtalk.service.commentservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.techtalk.domain.comment.Comment;
import toyproject.techtalk.dto.commentdto.CommentResponseDto;
import toyproject.techtalk.repository.BoardRepository;
import toyproject.techtalk.repository.CommentRepository;
import toyproject.techtalk.repository.UserRepository;
import toyproject.techtalk.utils.exception.comment.CommentNotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public List<CommentResponseDto> getAllComments(Long boardId) {
        List<Comment> commentList = commentRepository.findAllByBoardId(boardId);
        return CommentResponseDto.toListDto(commentList);
    }

    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
        commentRepository.delete(comment);
    }
}
