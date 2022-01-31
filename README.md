# 로그 추적기 개발 - Spring Aop 학습

## Goal

- 스프링 프록시 기술에 대한 이해와 동적 프록시 기술 이해
  - 프록시 패턴에 대한 학습
  - JDK 동적 프록시, CGLIB
- 프록시 기술을 바탕으로 AOP 기술의 이해와 활용
  - pointcut, advice, advisor에 대한 이해
  - 빈 후처리기 개념 학습
- Request 단위 로그 추적 기능 개발
  - 쓰레드 로컬을 사용하여 Request 단위 분리
- 응답시간 ms 단위로 로깅
- 예외처리
- 스프링 AOP의 한계점과 해결법
  - 프록시 AOP와 내부 호출

## 실제 동작 화면

- 정상 요청시 로그 추적

![첨부 이미지](https://github.com/jinia91/blogBackUp/blob/main/img/f9cd5e28-3afc-4f9f-80e0-2283d9dedff0.png?raw=true)

- 에러 발생시 로그 추적

![첨부 이미지](https://github.com/jinia91/blogBackUp/blob/main/img/c98023c9-45ff-4bc6-8fd5-6b45038699ed.png?raw=true)

