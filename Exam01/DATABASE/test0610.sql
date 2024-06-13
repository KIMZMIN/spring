
CREATE TABLE book_tbl_06(
    book_no number primary key
    , book_name VARCHAR2(50) NOT NULL
    , book_coverimg VARCHAR2(20)
    , book_date DATE
    , book_price number
    , book_publisher VARCHAR2(50)
    , book_info VARCHAR2(2000)
);

INSERT INTO book_tbl_06 ( 
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
    )
VALUES (
    100
    , '������'
    , '100.jpg'
    , TO_DATE('2015-09-02', 'yy/MM/dd')
    , '24000'
    , '���轺'
    , '�ü��, DB����,��Ʈ��ũ����, ����ȯ�汸��'
);

INSERT INTO book_tbl_06 ( 
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
    )
VALUES (
    101
    , '�ڹ�'
    , '101.jpg'
    , TO_DATE('2016-01-10', 'yy/MM/dd')
    , '20000'
    , '���ڹ�'
    , '���α׷��� ���'
);
INSERT INTO book_tbl_06 ( 
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
    )
VALUES (
    102
    , '�ڹ������α׷���'
    , '102.jpg'
    , TO_DATE('2016-10-30', 'yy/MM/dd')
    , '25000'
    , '������'
    , '����ȯ��/�������α׷�/��ġ���α׷�'
);
INSERT INTO book_tbl_06 ( 
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
    )
VALUES (
    103
    , '���¼ҽ�Ȱ���ϱ�'
    , '103.jpg'
    , TO_DATE('2017-09-01', 'yy/MM/dd')
    , '30000'
    , '�ڿ���'
    , '�������, ����, ����'
);
INSERT INTO book_tbl_06 ( 
    book_no
    , book_name
    , book_coverimg
    , book_date
    , book_price
    , book_publisher
    , book_info
    )
VALUES (
    104
    , 'HTML'
    , '104.jpg'
    , TO_DATE('2018-04-04', 'yy/MM/dd')
    , '10000'
    , 'ȫ�浿'
    , 'HTML/CSS/JAVASCRIPT/JQUERY'
);
        
CREATE TABLE rent_tbl_06(
    rent_no number primary key
    , book_no number NOT NULL
    , rent_price number NOT NULL
    , rent_date DATE NOT NULL
    , rent_status char(1) DEFAULT 0 NOT NULL
);
            
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10001
    , 100
    , 2400
    , TO_DATE('2018-07-02', 'yy/MM/dd')
    , 1
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10002
    , 101
    , 2000
    , TO_DATE('2018-07-04', 'yy/MM/dd')
    , 1
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10003
    , 100
    , 2400
    , TO_DATE('2018-08-02', 'yy/MM/dd')
    , 1
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10004
    , 100
    , 2400
    , TO_DATE('2018-08-12', 'yy/MM/dd')
    , 1
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10005
    , 102
    , 2500
    , TO_DATE('2018-08-13', 'yy/MM/dd')
    , 1
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10006
    , 103
    , 3000
    , TO_DATE('2018-08-13', 'yy/MM/dd')
    , 1
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10007
    , 103
    , 3000
    , TO_DATE('2018-08-20', 'yy/MM/dd')
    , 0
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10008
    , 100
    , 2400
    , TO_DATE('2018-09-03', 'yy/MM/dd')
    , 1
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10009
    , 100
    , 2400
    , TO_DATE('2018-09-08', 'yy/MM/dd')
    , 1
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10010
    , 100
    , 2400
    , TO_DATE('2018-09-14', 'yy/MM/dd')
    , 0
);
INSERT INTO rent_tbl_06 ( 
    rent_no
    , book_no
    , rent_price
    , rent_date
    , rent_status
    )
VALUES (
    10011
    , 102
    , 2500
    , TO_DATE('2018-09-14', 'yy/MM/dd')
    , 0
);

commit;