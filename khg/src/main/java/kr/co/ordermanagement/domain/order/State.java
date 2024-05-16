package kr.co.ordermanagement.domain.order;

import kr.co.ordermanagement.domain.exception.CanNotCancellableStateException;

public enum State {
    CREATED { //주문 생성
        @Override
        void checkCancellable() {}
    },
    SHIPPING,  //배송 중
    COMPLETED, //주문 완료
    CANCELED; //주문 취소

    void checkCancellable() {
        throw new CanNotCancellableStateException("이미 취소되었거나 취소할 수 없는 주문상태입니다.");
    }
}
