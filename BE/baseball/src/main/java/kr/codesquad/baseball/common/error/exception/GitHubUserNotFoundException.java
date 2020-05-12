package kr.codesquad.baseball.common.error.exception;

import kr.codesquad.baseball.common.error.ErrorCode;

public class GitHubUserNotFoundException extends EntityNotFoundException {
    public GitHubUserNotFoundException() {
        super(ErrorCode.GITHUB_USER_NOT_FOUND);
    }

    public GitHubUserNotFoundException(String message) {
        super(message, ErrorCode.GITHUB_USER_NOT_FOUND);
    }
}
