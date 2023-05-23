-- tbl_user(회원)
insert into tbl_user values('admin', '1234' , '관리자' ,	 '01027251861' , '서울시 강남구' , 'admin@pandashop.com' , default );
insert into tbl_user values('lys24', '1234' , '이유섭' , '01027251861' , '경기도 고양시' , 'mrlys24@naver.com' , default );

-- tbl_notice(공지)
insert into tbl_notice values( default , '사랑의열매와 함께하는 포토 콘테스트' , '전남사랑의열매와 함께하는 포토 콘테스트' , '관리자' , '/img/contest_notice01.png' , default , default );
insert into tbl_notice values( default , '승월마을 벚꽃축제 알림' , '승월마을 벚꽃축제 알림' , '관리자' , './img/sakura_notice02.png' , default ,	default	 );

-- tbl_place(장소)
insert into tbl_place values(  '만성리 검은모래 해변' , '0101' , '만성리길 15-1(만흥동)' , '061-651-4525' , '여수시 만흥동에 있는 만성리 바닷가로 가는 길에는 좀처럼 보기 힘든 터널이 있다.' , '/img/0101_mansung.png' );
insert into tbl_place values(  '용문사' , '0102' , '화양면 용문사길 91' , '061-682-6169' , '용문사는 여수시 화양면 용주리 1595번지 비봉산 중턱에 자리 잡은 아담한 사찰이다.' ,	'/img/0102_yongmun.png' );
insert into tbl_place values(  '빅오쇼' , '0103' , '박람회길 1 (덕충동)' , '061-659-2046' , '여수밤바다의 감동! 여수의 랜드마크! 세계적인 권위를 자랑하는 THEA Awards의 ‘2012 올해의 쇼’ 수상!' , '/img/0103_bigO.png' );
insert into tbl_place values(  '이퀼리브리엄' ,	'0201' , '엑스포아트갤러리' , '061-664-5465' , '엑스포아트갤러리-광주아시아문화전당 협력전<<이퀼리브리엄>> 전시연계 체험' , '/img/0201_equilibrium.png'  );
insert into tbl_place values(  '옷깃을 풀고 두다리 뻗고' , '0202' ,	'달빛갤러리' , '061-659-4760' , '고전 한문 서예에 현대적 감각으로 채색을 더해 자신만의 서풍격(書風格)을 만들어낸 정여춘 작가의 서예 작품' , '/img/0202_otgit.png'  );
insert into tbl_place values(  '여수문화예술 100년 토크콘서트' , '0203' , '시민회관' , '061-659-3776' , '여수문화예술 100년 토크콘서트, 여수문화예술 토크 및 클래식 공연' , '/img/0203_talkConcert.png'  );
insert into tbl_place values(  '칙바이칙' , '0301' , '웅천남7로 24 (웅천동)롯데캐슬마리나 상가 A동 101호' , '061-686-7827' , '햄버거집입니다.' , '/img/0301_chickByChick.png'	 );
insert into tbl_place values(  '소노캄 여수' , '0302' , '오동도로 111 (수정동)' , '061-660-5800' , '세계 4대 미항 여수의 오동도와 2012여수세계박람회장에 위치한 소노캄 여수는 고객님의 가장 가치 있는 삶이 머무는 공간입니다.' , '/img/0302_sonocalm.png' );
insert into tbl_place values(  '도깨비시장' , '0303' , '학동서5길 18 (학동)' , '061-683-1505' , '도깨비 시장의 유래는 옛날 이 부근에 시장이 섰다 사라지곤 해서 이곳 사람들은 도깨비시장이라고 불렀다고 한다. ' , '/img/0303_doggaebi.png' );
insert into tbl_place values(  '아쿠아플라넷 여수' , '0401' , '오동도로 61-11 (수정동)' , '061-660-1111' , '세계적인 해양생물을 만날 수 있는 해양생태관! ' , '/img/0401_aquaPlanet.png'	 );
insert into tbl_place values(  '여수해상케이블카' , '0402' ,	 '돌산읍 돌산로 3600-1' , '061-664-7301' , '오동도 거문도.백도 향일암 금오도비렁길 여수세계박람회장 진남관 여수밤바다.' , '/img/0302_cablecar.png' );
insert into tbl_place values(  '웅천친수공원텐트촌' , '0403' , '웅천동 1962' , '061-690-2357' , '도시민과 관광객이 청정해역인 가막만을 감상하면서, 휴식을 취할 수 있는 공간을 조성한 웅천택지지구내 위치한 도시 근린공원이다.' , '/img/0403_woongcheon.png'	 );

-- tbl_cate(카테)
insert into tbl_cate values( '0101' , '명소주제별' , '섬/해변' );
insert into tbl_cate values( '0202' , '명소주제별' , '산/사찰' );
insert into tbl_cate values( '0303' , '명소주제별' , '문화/경승지' );
insert into tbl_cate values( '0201' , '전시회장소별' , '엑스포아트갤러리' );
insert into tbl_cate values( '0202' , '전시회장소별' , '달빛갤러리' );
insert into tbl_cate values( '0203' , '전시회장소별' , '시민회관' );
insert into tbl_cate values( '0301' , '업체주제별' , '음식점' );
insert into tbl_cate values( '0302' , '업체주제별' , '숙박'  );
insert into tbl_cate values( '0303' , '업체주제별' , '쇼핑'  );
insert into tbl_cate values( '0401' , '체험주제별' , '관람'  );
insert into tbl_cate values( '0402' , '체험주제별' , '레저'  );
insert into tbl_cate values( '0403' , '체험주제별' , '캠핑'  );

-- tbl_review

insert into tbl_review values(default, '0101', '0001', 'lys24', '너무 좋았어요', '/img/0401_aquaPlanet.png', default);



