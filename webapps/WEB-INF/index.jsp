<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
  <head>
  	<%@ include file="../common.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>메인 페이지</title>    
  </head>
<style>
h1 {text-align: center;}
h2 {text-align: center;}

.container {width:1280px; height: 900px; margin: 0 auto;}
#page1 {height: 550px;}
#page2 {height: 1400px;}
#page3 {height: 900px;}
#page4 {height: 1200px;}
.main_comment { content:""; display:block; width:510px; height:185px; background-image:url("./img/main_sp.png");
	 background-repeat: no-repeat; background-position:0px -35px; margin-top:0 auto; 
		  transform: translate(0%,70%);} 
.img_box input {display: none;}
.img_box .slideWrap {max-width:1280px; margin:0 auto; overflow: hidden;}
.img_box .slideList {white-space:nowrap; font-size: 0;}
.img_box .slideList > li {display: inline-block; vertical-align: middle; width: 100%; transition: all .5s;}
.img_box .slideList > li > a {display : block; position: relative;}
.img_box .slideList > li > a img {width:100%; }
.img_box .slideList label {position:absolute; z-index:10; top: 50%; transform : translateY(-50%); padding:50px; cursor: pointer;}
.img_box .slideList .left {left:30px; background: url("${path1 }/img/left.png") center center / 100% no-repeat;}
.img_box .slideList .right {right:30px; background: url("${path1 }/img/right.png") center center / 100% no-repeat;} 
.img_box [id="slide01_01"]:checked ~ .slideWrap .slideList > li {transform:translateX(0%);}
.img_box [id="slide01_02"]:checked ~ .slideWrap .slideList > li {transform:translateX(-100%);}
.img_box [id="slide01_03"]:checked ~ .slideWrap .slideList > li {transform:translateX(-200%);}

.fest_img_box {text-align: center;}
.fest_img_box .slideWrap {max-width:1280px; margin:0 auto; overflow: hidden; }
.fest_img_box .slideList {white-space:nowrap; font-size: 0;}
.fest_img_box .slideList > li {display: inline-block; vertical-align: middle; width: 100%; transition: all .5s;}
.fest_img_box .slideList > li > a {display : block; position: relative;}
.fest_img_box .slideList > li > a img {width:500px; margin-left: display:block; float: left; }
.fest_img_box .slideList label { position:absolute; z-index:10; top:300px;  transform : translateY(-50%); padding:20px;  cursor: pointer;}
.fest_img_box .slideList .left {left:0px; background: url("${path1 }/img/left.png") center center / 100% no-repeat;}
.fest_img_box .slideList .right {right:0px; background: url("${path1 }/img/right.png") center center / 100% no-repeat;} 
.fest_img_box [id="slide02_01"]:checked ~ .slideWrap .slideList > li {transform:translateX(0%);}
.fest_img_box [id="slide02_02"]:checked ~ .slideWrap .slideList > li {transform:translateX(-100%);}
.fest_img_box [id="slide02_03"]:checked ~ .slideWrap .slideList > li {transform:translateX(-200%);}
.fest_img_box [id="slide02_04"]:checked ~ .slideWrap .slideList > li {transform:translateX(-300%);}
.fest_img_box [id="slide02_05"]:checked ~ .slideWrap .slideList > li {transform:translateX(-400%);}
.fest_img_box [id="slide02_06"]:checked ~ .slideWrap .slideList > li {transform:translateX(-500%);}
.fest_img_box [id="slide02_07"]:checked ~ .slideWrap .slideList > li {transform:translateX(-600%);}
.content is-normal {display:block; float: left;}
#fest_con {margin-top: 50px;}
#fest_con h1 { margin-left: 520px;}
#fest_con h2 { margin-left: 520px;}
#fest_con p {margin-left: 520px;}

</style>
	<body>
<%@ include file="../header.jsp" %>
		<section class="section">
			<div class="container" id="page1">
				<div class="main_img">				
					<div class="img_box" style= "position:absolute; width:100%; display:block; margin:0 auto; z-index: 1;" >
						<input type="radio" name="slide01" id="slide01_01" checked>
						<input type="radio" name="slide01" id="slide01_02">
						<input type="radio" name="slide01" id="slide01_03">
						<div class="slideWrap">
							<ul class="slideList">
								<li>
									<a>
										<label for="slide01_03" class="left"></label>
											<img src="${path1 }/img/mainimg1.png" >
										<label for="slide01_02" class="right"></label>
									</a>	
								</li>							
								<li>
									<a>
										<label for="slide01_01" class="left"></label>
											<img src="${path1 }/img/mainimg2.png" >
										<label for="slide01_03" class="right"></label>
									</a>
								</li>
								<li>
									<a>
										<label for="slide01_02" class="left"></label>
											<img src="${path1 }/img/mainimg3.png" >
										<label for="slide01_01" class="right"></label>
									</a>
								</li>
							</ul>					
						</div>						
					</div>					
				</div>
				<div class="main_comment" style= "display:block; margin:0 auto; position:relative ; z-index: 3;" >
				</div>
			</div>		
									
			<div class="container" id="page2" >
				<h1 class="title is-1 has-text-info-dark">여수 10경</h1>
				<div class="tile is-ancestor">
					<div class="tile is-vertical is-12">
   						<div class="tile">
			   	 			<div class="tile is-parent is-vertical">
			        			<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">오동도</p>			          			
							        <figure class="image is-5by1">
							        	<img src="${path1 }/img/10view_odongdo.png">
							        </figure>			          				
			       				</article>
			        			<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">거문도/백도</p>
									<figure class="image is-5by1">
							       		<img src="${path1 }/img/10view_geomundo.png">
							        </figure>		
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">항일암</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10view_hangilam.png">
							        </figure>		
			          				
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">금오도 비렁길</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10view_gumodo.png">
							        </figure>		
			          				
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">여수세계박람회장</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10view_expo.png">
							        </figure>		
			       				</article>			       				
			      			</div>
			      			<div class="tile is-parent is-vertical">
			      				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">진남관</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10view_jinnam.png">
							        </figure>		
			       				</article>
			        			<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">여수밤바다/산단야경</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10view_nightsea.png">
							        </figure>		
			       				</article>
			        			<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">영취산 진달래</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10view_yeong.png">
							        </figure>		
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">여수 해상 케이블카</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10view_cable.png">
							        </figure>		
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">여수 이순신 대교</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10view_yisunsin.png">
							        </figure>		
			       				</article>			       			       				
			      			</div>			      							      		
 						</div>
					</div>
				</div>	
			</div>	
										
			<div class="container" id="page3" >
				<h1 class="title is-1 has-text-info-dark">주요 축제</h1>			
				<div class="fest_img">	
					<div class="fest_img_box" style= "position:absolute; width:100%; display:block; margin:0 auto; z-index: 1;" >
						<input type="radio" name="slide02" id="slide02_01" checked>
						<input type="radio" name="slide02" id="slide02_02">
						<input type="radio" name="slide02" id="slide02_03">
						<input type="radio" name="slide02" id="slide02_04">
						<input type="radio" name="slide02" id="slide02_05">
						<input type="radio" name="slide02" id="slide02_06">
						<input type="radio" name="slide02" id="slide02_07">
						<div class="slideWrap">
							<ul class="slideList">
								<li>
									<a>영취산은 3~4월이 되면 진달래로 온 산이 붉게 타오른다. 매년 영취산 진달래 축제가 개최되고, 축제 기간 중에는 산신제, 산상음악회 등 다채로운 행사가 상춘객들에게 볼거리를 제공한다.
										<label for="slide02_07" class="left"></label>
											<img src="${path1 }/img/festival_01.png" >																				
										<label for="slide02_02" class="right"></label>										
									</a>
									<div class="content is-normal" id="fest_con">
								 		<h1>제31회 여수영취산진달래체험행사</h1>
					    				<p>영취산은 3~4월이 되면 진달래로 온 산이 붉게 타오른다.</p>
					    				<p>매년 영취산 진달래 축제가 개최되고, 축제 기간 중에는 산신제,</p>
					    				<p>산상음악회 등 다채로운 행사가 상춘객들에게 볼거리를 제공한다.</p>
						    			<h2>연분홍 영취산 진달래꽃으로 </h2>
						    			<h2>봄의 정취에 흠뻑 젖어보세요</h2>						    			
					      				<p>기간 : 2023. 4. 1.(토) ~ 4. 2.(일)</p>
					      				<p>장소 : 흥국사 산림공원 일원</p>
					      				<p>주최/주관 : 여수시.여수영취산진달래체험행사추진위원회</p>
					      				<p><a href="http://yeosujindalrae.co.kr">클릭시 영취산 진달래축제 홈페이지 바로가기</a></p>
					      				<br>
					      				<p>문의사항</p>
					      				<p>영취산진달래체험행사추진위원회 사무실 : 061-691-3104</p>
					      				<p>여수시 문화예술과 축제지원팀 : 061-659-4744</p>
						    		</div>		
								</li>							
								<li>
									<a>
										<label for="slide02_01" class="left"></label>
											<img src="${path1 }/img/festival_02.png" >
										<label for="slide02_03" class="right"></label>
									</a>
									<div class="content is-normal" id="fest_con">
								 		<h1>제57회 여수거북선축제</h1>
					    				<h3>주요 행사 내용</h4>
					    				<br>						    				
					    				<h4>제례행사</h4>
					    				<p>일 시: 2023. 5. 4.(목) 08:30 ~ 12:00</p>
					    				<h4>주먹밥 만들기 및 나누기</h4>	
					    				<p>일 시: 2023. 5. 4.(목) 18:00 ~ 18:30</p>					    				
					    				<h4>출정식</h4>
					    				<p>일 시: 2023. 5. 4.(목) 18:50</p>
					    				<h4>통제영길놀이</h4>
					    				<p>일 시: 2023. 5. 4.(목) 19:00 ~ 20:20</p>
					    				<h4>개막식</h4>
					    				<p>일 시: 2023. 5. 4.(목) 20:20 ~ 22:00</p>					    			  							    			
					      				<p><a href="http://yeosujindalrae.co.kr">클릭시 영취산 진달래축제 홈페이지 바로가기</a></p>						      									      				
						    		</div>
								</li>
								<li>
									<a>
										<label for="slide02_02" class="left"></label>
											<img src="${path1 }/img/festival_03.png" >
										<label for="slide02_04" class="right"></label>
									</a>
									<div class="content is-normal" id="fest_con">
								 		<h1>제27회 여수향일암일출제</h1>
								 		<br>
					    				<p>국내 최고의 해돋이 명소인 향일암은 우리나라 4대 관음 기도처 중 하나로</p>
					    				<p>이곳에서 기도를 드리면 많은 소원이 이루어진다고 전해집니다.</p>	
					    				<br><br>					    				
						    			<h2>새해 소원성취의 기운을 받으세요!</h2>						    			
					      				<p>기간 : 2022. 12. 31.(토) ~ 2023. 1. 1.(일)/ 2일간</p>
					      				<p>장소 : 돌산읍 임포마을(향일암) 일원</p>
					      				<p>주요행사 : 일몰·일출감상, 제야의 종 타종, 불꽃쇼, 체험행사 등</p>
					      				<p>주최/주관: 여수시/여수향일암일출제추진위원회</p>						      										      				
						    		</div>
								</li>
								<li>
									<a>
										<label for="slide02_03" class="left"></label>
											<img src="${path1 }/img/festival_04.png" >
										<label for="slide02_05" class="right"></label>
									</a>
									<div class="content is-normal" id="fest_con">
								 		<h1>여수 밤바다 불꽃축제</h1>
								 		<br><br><br>						    							    					    			
					      				<h3>일시 : 2022. 10. 22.(토) 18:30~21:20</h3>
					      				<h3>장소 : 이순신광장 및 장군도 앞 해상</h3>
					      				<h3>주 제 : 우리, 다시 여수밤바다로</h3>
					      				<h3>주최/주관 : 여수시/여수밤바다불꽃축제추진위원회</h3>
					      				<h3><a href="https://www.yeosu.go.kr/ysff">클릭시 여수밤바다 불꽃축제 홈페이지 바로가기</a></h3>						      				
						    		</div>
								</li>
								<li>
									<a>
										<label for="slide02_04" class="left"></label>
											<img src="${path1 }/img/festival_05.png" >
										<label for="slide02_06" class="right"></label>
									</a>
									<div class="content is-normal" id="fest_con">
								 		<h1>2022 여수동동북축제</h1>
								 		<br>
					    				<h4>대형 북 퍼레이드</h4>
					    				<h4>메인 아티스트 공연</h4>
					    				<h4>북·드럼 경연대회</h4>						    				
					    				<h4>축하공연</h4>
					    				<h4>부대행사 등</h4>
					    				<br>
						    			<h2>축제개요</h2>						    			
					      				<p>기　　간 : 2022. 11. 26.(토) ∼ 11. 27.(일)/ 2일간</p>
					      				<p>장 소 : 용기공원 및 선소 일원</p>
					      				<p>주 제 : 동동! 내일을 향한 힘찬 울림!</p>
					      				<p>주 제 :주요행사 : 북 퍼레이드 메인 아티스트 공연, 마스터클래스, 각종 전시·체험행사 등</p>
					      				<p>주최/주관 : 여수시/2022여수동동북축제추진위원회</p>
					      				<p><a href="https://www.yeosu.go.kr/dongdong">클릭시 여수동동북축제 홈페이지 바로가기</a></p>					      				
						    		</div>
								</li>
								<li>
									<a>
										<label for="slide02_05" class="left"></label>
											<img src="${path1 }/img/festival_06.png" >
										<label for="slide02_07" class="right"></label>
									</a>
									<div class="content is-normal" id="fest_con">
								 		<h1>여수밤바다 낭만버스킹</h1>
								 		<br>
					    				<h3>코로나19로 무기한 연기되었던 </h3>
					    				<h3>낭만 ＆ 청춘 버스킹이 매주 금~토요일 찾아옵니다.</h3>
					    				<h3>낭만버스킹 : 5. 6. ~ 10. 22. 매주 금 ~ 토</h3>
					    				<h3>청춘버스킹 : 5. 21. ~ 10. 22. 매주 토</h3>
					    				<br>
					      				<p><a href="http://낭만버스킹.com/main/index.html">클릭시 낭만버스킹 홈페이지 바로가기</a></p>						      				
						    		</div>
								</li>
								<li>
									<a>
										<label for="slide02_06" class="left"></label>
											<img src="${path1 }/img/festival_07.png" >
										<label for="slide02_01" class="right"></label>
									</a>
									<div class="content is-normal" id="fest_con">
								 		<h1>제29회 남도음식문화큰잔치</h1>
								 		<br>
							 			<h3>주요 프로그램</h3>
					    				<p>힐링 문화공연</p>
					    				<p>체험 및 특별프로그램</p>
					    				<p>세계화 프로그램</p>						    				
						    			<h2>남도의 맛! 세계를 잇다!</h2>
						    			<br>						    			
					      				<p>2023. 10. 6.(금) ~ 8.(일) 3일간</p>
					      				<p>여수 세계박람회장 일원</p>
					      				<p>주최/주관 : 전라남도, 여수시</p>
					      				<p>후원 : 농림축산식품부, 식품의약품안전처, 한국관광공사</p>
					      				<p><a href="http://www.namdofood.or.kr/main#__269523__item1">클릭시 남도 음식문화 큰잔치 홈페이지 바로가기</a></p>						      									      				
						    		</div>
								</li>
							</ul>					
						</div>						
					</div>					
				</div>				
			</div>		
			
			<div class="container" id="page4" >
				<h1 class="title is-1 has-text-info-dark">여수 10미</h1>
				<div class="tile is-ancestor">
					<div class="tile is-vertical is-12">
   						<div class="tile">
			   	 			<div class="tile is-parent is-vertical">
			        			<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">돌산갓김치</p>			          			
							        <figure class="image is-5by1">
							        	<img src="${path1 }/img/10food_gatkimchi.png">
							        </figure>			          				
			       				</article>
			        			<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">게장백반</p>
									<figure class="image is-5by1">
							       		<img src="${path1 }/img/10food_gejang.png">
							        </figure>		
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">서대회</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10food_seodaehoe.png">
							        </figure>		
			          				
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">여수한정식</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10food_hanjeongsik.png">
							        </figure>		
			          				
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">갯장어회/샤브샤브</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10food_eel.png">
							        </figure>		
			       				</article>			       				
			      			</div>
			      			<div class="tile is-parent is-vertical">
			      				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">굴구이</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10food_oyster.png">
							        </figure>		
			       				</article>
			        			<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">장어구이/탕</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10food_broiled_eel.png">
							        </figure>		
			       				</article>
			        			<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">갈치조림</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10food_galchi.png">
							        </figure>		
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">새조개 샤브샤브</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10food_cockie.png">
							        </figure>		
			       				</article>
			       				<article class="tile is-child notification has-background-info-light">
			          				<p class="title has-text-info-dark">전어구이/회</p>
			          				<figure class="image is-5by1">
							       		<img src="${path1 }/img/10food_gizzard.png">
							        </figure>		
			       				</article>			       			       				
			      			</div>			      							      		
 						</div>
					</div>
				</div>	
			</div>		
							
		</section>		
<%@ include file="../footer.jsp" %> 
	</body>
</html>
