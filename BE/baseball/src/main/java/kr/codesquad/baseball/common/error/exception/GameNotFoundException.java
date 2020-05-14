package kr.codesquad.baseball.common.error.exception;

import kr.codesquad.baseball.common.error.ErrorCode;

public class GameNotFoundException extends EntityNotFoundException {

    public GameNotFoundException() {
        super(ErrorCode.GAME_NOT_FOUND);
    }

    public GameNotFoundException(String message) {
        super(message, ErrorCode.GAME_NOT_FOUND);
    }
}
