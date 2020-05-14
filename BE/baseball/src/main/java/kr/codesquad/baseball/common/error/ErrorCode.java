package kr.codesquad.baseball.common.error;

public enum ErrorCode {
    // Common
    ENTITY_NOT_FOUND(404, "COM001", " Entity Not Found"),
    INVALID_TYPE_VALUE(400, "COM002", "Wrong Type"),
    INVALID_INPUT_VALUE(400, "COM003", "Wrong InputValue"),
    METHOD_NOT_ALLOWED(405, "COM004", "Change Http Method"),
    INTERNAL_SERVER_ERROR(500, "COM005", "백엔드 개발자라 죄송합니다..."),
    NOT_YOUR_PITCH_TURN(400, "COM006", "공을 던질 차례가 아니에요."),
    // User
    USER_NOT_FOUND(404, "U001", " 해당 사용자가 존재하지 않습니다."),
    LOGIN_REQUIRED(401, "U002", " 로그인을 해주세요."),
    GITHUB_USER_NOT_FOUND(404, "U003", " GitHub에서 해당 사용자를 조회하지 못했습니다."),
    // GAME
    GAME_NOT_FOUND(404, "G001", "해당 게임이 존재하지 않아요!"),
    GAME_NOT_SUCCESSFULLY_INITILIZED(500, "G002", "게임이 정상적으로 실행되지 않았어요."),
    ;

    private final String code;
    private final String message;
    private final int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
