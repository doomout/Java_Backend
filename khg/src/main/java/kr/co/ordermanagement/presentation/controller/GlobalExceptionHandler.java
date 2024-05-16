package kr.co.ordermanagement.presentation.controller;

import kr.co.ordermanagement.domain.exception.CanNotCancellableStateException;
import kr.co.ordermanagement.domain.exception.EntityNotFoundException;
import kr.co.ordermanagement.domain.exception.NotEnoughAmountException;
import kr.co.ordermanagement.presentation.dto.ErrorMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CanNotCancellableStateException.class)
    public ResponseEntity<ErrorMessageDto> handleCanNotCancellableState(  //주문을 취소할 수 없는 상태 예외 처리
            CanNotCancellableStateException ex
    ) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage());
        
        //각 예외에 대한 오류 메시지를 ErrorMessageDto로 래핑하여 반환
        return new ResponseEntity<>(errorMessageDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleEntityNotFoundException( //엔티티를 찾을 수 없는 예외 처리
            EntityNotFoundException ex
    ) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage());
        
        //각 예외에 대한 오류 메시지를 ErrorMessageDto로 래핑하여 반환
        return new ResponseEntity<>(errorMessageDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotEnoughAmountException.class)
    public ResponseEntity<ErrorMessageDto> handleNotEnoughAmountException( //재고 수량 부족 예외 처리
            NotEnoughAmountException ex
    ) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage());

        //각 예외에 대한 오류 메시지를 ErrorMessageDto로 래핑하여 반환
        return new ResponseEntity<>(errorMessageDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
