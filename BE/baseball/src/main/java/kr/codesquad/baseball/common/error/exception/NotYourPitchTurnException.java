package kr.codesquad.baseball.common.error.exception;

import kr.codesquad.baseball.common.error.ErrorCode;

public class NotYourPitchTurnException extends BusinessException {

    public NotYourPitchTurnException() {
        super(ErrorCode.NOT_YOUR_PITCH_TURN);
    }

    public NotYourPitchTurnException(String message) {
        super(message, ErrorCode.NOT_YOUR_PITCH_TURN);
    }
}
