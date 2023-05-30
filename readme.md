# 프로젝트 개요 

## 프로젝트 명 : 여수 문화관광 웹 애플리케이션

## 프로젝트 기간 : 2023.05.03~13

## 프로젝트 참여 : 이유섭 , 허준

## 자바 버젼 : jdk 1.8

## 다이나믹 웹 모듈 : 3.1

## 사용 DBMS : MySQL 

## 자바 사용 라이브러리 : crypto, json, cos, commons, mail

## CSS 프레임 워크 : bulma

## 자바스크립트 플러그인 : jQuery

## 자바 스크립트 api : daum주소 api, json 데이터 처리, iamport 결제 api

## 프로젝트 데이터 처리 패턴 : MVCZ(View ->Controller -> Model -> Comtroller -> View)

## 프로젝트 주요 기능 : 회원, 공지사항, 질문 및 답변, 자주 묻는 질문, 리뷰기능

## 프로젝트 특이사항
- 회원 가입시 중복 체크는 json을 활용 하여 별도의 팝업 창이 없이 현재 창에서 구현
- 회원가입시 주소의 입력은 daum주소 api를 활용하여 주소를 전달
- 회원의 비밀번호는 md5, sha25, aes256등으로 암호화하여 처리
-place(장소) 테이블은 관광명소(명소주제별), 문화축제(전시회장소별), 음식점/숙박/쇼핑
(업체주제별), 여행/체험(체험주제별)로 세분화 된다.
- 명소주제별 카테고리는 섬/해변 , 산/사찰, 문화/경승지로 나뉜다.
- 전시회장소별 카테고리는 엑스포아트갤러리, 달빛갤러리, 시민회관 으로 나뉜다
- 음식점/숙박/쇼핑(업체주제별)은 음식점, 숙박, 쇼핑으로 나뉜다.
여행/체험(체험주제별)은 관람, 레저, 캠핑으로 나뉜다.
- 리뷰는 장소마다 작성 가능하고 후기 사진 첨부 가능하다.
- 공지사항은 파일 첨부(업로드) 기능을 함께 구현
- 공지사항 전체 목록의 페이징 처리와 검색 기능 구현
- 공지사항 글의 상세보기 화면에서 해당 게시된 공지 중에서 파일 다운로드 기능 추가

---------------------------------------------------------------------------
