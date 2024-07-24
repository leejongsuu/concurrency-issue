# concurrency-issue
재고 시스템을 예로 동시성 이슈를 해결하는 방법을 학습

</br>


## 동시성 문제❗

- 상품 재고가 안맞아요

  ![Untitled](https://github.com/user-attachments/assets/32a0606c-9b6f-436e-93fa-acd2e380c788)

</br>

## 문제 해결 ⭕

### ✅ Application Level

- **`synchronized`** 사용

  ![Untitled (1)](https://github.com/user-attachments/assets/220554df-50a5-4e7a-868a-418424f86484)

### ✅ Database Lock

Database이 제공하는 **`lock`** 을 이용해서 동시성을 제어

- Pessimistic Lock
- Optimistic Lock
- Named Lock

### ✅ Redis Distributed Lock

분산 환경에서 **`Redis`** 를 활용하여 동시성을 제어

- 라이브러리 비교
- Redis Cli를 통한 명령어 실습

</br>

# branch
- **`main`** : 초반 세팅 및 재고 감소 로직 작성 -> race condition 없을 시 테스트 성공
- **`problem`** : 다수의 스레드로 동시에 재고 감소를 했을 때 문제가 발생 -> Race Condition
- **`synchronized`** : synchronized를 통해 Race Condition을 해결, synchronized의 특징과 문제점
