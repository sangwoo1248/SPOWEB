drop table product purge;

CREATE TABLE product(
	sCode VARCHAR2(40) PRIMARY KEY,
    sCategory VARCHAR2(20) Not Null,
    sName VARCHAR2(50) NOT NULL,
    sPrice number(7) NOT NULL,
    sContent  VARCHAR2(3000) NOT NULL,
    sImage VARCHAR2(20) NOT NULL
);

--상의 --
INSERT INTO product
VALUES('TS01', 'TOP', '블랙 긴팔 티셔츠', '49900', 
       '언더 앞 패널부분의 매쉬 소재로 쾌적한 착용감!!', 'top1');

INSERT INTO PRODUCT
VALUES('TS02', 'TOP', '블랙 반팔 기능성 티셔츠', '39900', 
       '언더 앞 패널부분의 매쉬 소재로 쾌적한 착용감!!', 'top2');

INSERT INTO PRODUCT
VALUES('TS03', 'TOP', '남성 트레이닝 벡터 긴팔 컴프레션 티셔츠 ', '39900', 
       '신체활동에 적합한 컴프레션 웨어!!', 'top3');

INSERT INTO PRODUCT
VALUES('TS04', 'TOP', '블랙 프로 컴프레션 기능성 반팔티', '47500', 
       '쾌적한 착용감!!', 'top4');

INSERT INTO PRODUCT
VALUES('TS05', 'TOP', 'T-익스트림 스포츠 티셔츠 블랙', '5900', 
       '활동적인 스포츠 및 레저 활동에 적합한 티셔츠!!', 'top5');
commit;

--하의--
INSERT INTO PRODUCT
VALUES('BS01', 'BOTTOM', '퀼리파이어 우븐 쇼츠', '49000', 
       '여름용 기능성 하의!!', 'b1');

INSERT INTO PRODUCT
VALUES('BS02', 'BOTTOM', '사이드 스냅 트랙 팬츠', '49000', 
       '사이드 스냅 버튼으로 다양한 스타일링을 즐길 수 있습니다(하단 3개버튼만 오픈)', 'b2');

INSERT INTO PRODUCT
VALUES('BS03', 'BOTTOM', ' 크로커 트레이닝 맨즈 팬츠', '75000', 
       '활동성을 위한 고기능성 사방스판 원단 적용', 'b3');       

INSERT INTO PRODUCT
VALUES('BS04', 'BOTTOM', '파일럿피쉬 하프 팬츠', '13200', 
       'Water Zero 방수, 투습, 방품 소재 적용', 'b4');

INSERT INTO PRODUCT
VALUES('BS05', 'BOTTOM', '마코 샤크 맨즈 레깅스', '67000', 
       '폴리 스판소재로 내구성과 신축성이 뛰어나 편안한 착용감 제공', 'b5');
commit;

--신발(농구화)--
INSERT INTO PRODUCT
VALUES('SS01', 'SHOES', '카이리 플라이트랩', '95535', 
       '튼튼한 바디와 가벼움 그리고 줌에어 스펙으로 가격 대비 풍부한 쿠셔닝을 제공', 's1');

INSERT INTO PRODUCT
VALUES('SS02', 'SHOES', '조던1 미드 카고', '120000', 
       '가벼운 착화감을 보여주며, 독특한 디자인 깔끔한 블랙톤 컬러', 's2');
       
INSERT INTO PRODUCT
VALUES('SS03', 'SHOES', '조던13 레트로 LA 레이커스', '258000', 
       '전형적인 LA 레이커스 컬러를 입은 에어조던13 레트로', 's3');
       
INSERT INTO PRODUCT
VALUES('SS04', 'SHOES', '줌 르브론3', '229000', 
       '줌에어 시스템이 적용되어 편안한 착화감을 제공', 's4');
       
INSERT INTO PRODUCT
VALUES('SS05', 'SHOES', '넥스트 레벨', '239000', 
       '레이스가 없는 프라임니트 갑피 구조로 마치 양말을 신듯 편안하게 착용 가능 마블 컬래버레이션(캡틴아메리카)', 
       's5');
commit;

-- 회원가입--
create table member
(
  userid varchar2(10) primary key,
  passwd varchar2(10) not null,
  username varchar2(10) not null,
  post varchar2(6) not null,
  addr1 varchar2(500) not null,
  addr2 varchar2(500) not null,
  phone1 varchar2(3) not null,
  phone2 varchar2(4) not null,
  phone3 varchar2(4) not null,
  email1 varchar2(20) not null,
  email2 varchar2(20) not null
);

--장바구니--
   drop table scart purge;
  create table scart
  (  num NUMBER(6) PRIMARY KEY,
     userid VARCHAR2(10),
     sCode varchar2(20) not null,
     sName varchar2(50) not null,
     sPrice NUMBER(6) not null,
     sSize CHAR(1) not null,
     sColor VARCHAR2(10) not null,
     sAmount NUMBER(2) not null,
     sImage varchar2(20) not null
  );   
   
  alter table scart
  add CONSTRAINT scart_userid_fk FOREIGN KEY(userid)
   REFERENCES member(userid) ON DELETE CASCADE;
   
  alter table scart
  add CONSTRAINT scart_gCode_fk FOREIGN KEY(sCode)
   REFERENCES product(sCode) ON DELETE CASCADE; 
   
  drop sequence scart_seq;
   
 create sequence scart_seq;
 
 select * from user_sequences;
    
   --주문 테이블--
   drop table sorderInfo purge;
   create table sorderInfo
  (  num NUMBER(6) PRIMARY KEY,
     userid VARCHAR2(10),
     sCode varchar2(20) not null,
     sName varchar2(50) not null,
     sPrice NUMBER(6) not null,
     sSize CHAR(1) not null,
     sColor VARCHAR2(10) not null,
     sAmount NUMBER(2) not null,
     sImage varchar2(20) not null,
     orderName VARCHAR2(10) NOT NULL,
     post VARCHAR2(5) NOT NULL,
     addr1 VARCHAR2(500) NOT NULL,
     addr2 VARCHAR2(500) NOT NULL,
     phone VARCHAR2(11) NOT NULL,
     payMethod VARCHAR2(10) NOT NULL,
     orderDay DATE  DEFAULT SYSDATE
  );   
  alter table sorderInfo
  add CONSTRAINT sorderInfo_userid_fk FOREIGN KEY(userid)
   REFERENCES member(userid) ON DELETE CASCADE;
   
   
  alter table sorderInfo
  add CONSTRAINT sorderInfo_gCode_fk FOREIGN KEY(gCode)
   REFERENCES product(gCode) ON DELETE CASCADE; 
   
  create sequence sorderInfo_seq;   