package toyproject.techtalk.domain.comment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toyproject.techtalk.domain.board.Board;
import toyproject.techtalk.domain.user.User;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(nullable = false)
    private String content;

    private LocalDateTime createdTime;
}
