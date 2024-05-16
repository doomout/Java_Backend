package kr.co.ordermanagement.presentation.dto;

public class ErrorMessageDto {
    private String message;

    public ErrorMessageDto(String message) {  //오류 메시지를 포함하는 메시지 필드
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
