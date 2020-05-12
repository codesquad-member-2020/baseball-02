package kr.codesquad.baseball.common.error.exception;

import kr.codesquad.baseball.common.error.ErrorCode;

public class GameNotInitializedException extends BusinessException {

    public GameNotInitializedException() {
        super(ErrorCode.GAME_NOT_SUCCESSFULLY_INITILIZED);
    }

    public GameNotInitializedException(String message) {
        super(message, ErrorCode.GAME_NOT_SUCCESSFULLY_INITILIZED);
    }
}
