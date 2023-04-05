use scott;
-- where SAL>=800 and comm is not null;
/*
select * 
from emp
where SAL <= (select avg(SAL) from emp );

select empno en,ename irum,sal pay,job
from emp
where sal <= 3000
order by sal;
*/
/*
select deptno,empno,hiredate,ename,sal
from emp
order by deptno, hiredate
limit 0, 5;*/

-- select abs(-100); 절대값

-- ceiling(3.7) 지정한 값보다 큰 정수
-- floor(3.7) 지정한 값보다 작은 정수
-- round(3.7) 반올림
-- select ceiling(3.7), floor(3.7), round(3.7);

-- select mod(14, 3), 14 % 3, 14 mod 3; 나머지
-- select pow(3,2), sqrt(16); 제곱
-- select truncate(1234.1294, 2), truncate(1234.1234,-2); -2는 정수 자릿수

-- SELECT ASCII('Z');
-- SELECT CHAR(65); -- A가 나옴

-- SELECT BIT_LENGTH('abc'), CHAR_LENGTH('abc'), LENGTH('abc');
-- 24 3 3
-- SELECT BIT_LENGTH('가나다'), CHAR_LENGTH('가나다'), LENGTH('가나다');
-- 72 3 9

-- select concat('2020','01','01');
-- select concat_ws('#','2020','01','01'); 구분자 넣어서 합쳐줌

-- select elt(2,'a','b','c'); 나열된 것들중에 index값에 맞게 출력해줌
-- select field('C','a','b','c'); 대/소문자에 상관없이 찾아줌
-- select find_in_set('C','a,b,c,'); 나열된 문자열에서 찾아줌
-- select instr('abcd','d'); 문자열 안에서 원하는 값의 인덱스 돌려줌
-- select locate('b','abcd');
-- select format(123.1254,2);
-- select bin(10),hex(10),oct(10); 2,8,12진수로 바꿔줌
-- select insert('가나다라마',1,3,'@@@'); 원하는 위치에 문자열 삽입
-- select concat(left('가나라다마바사',2),right('가나다라마바사',2));
-- select lpad('가나다',5,'@@@');
-- select rpad('가나다',5,'@@@');

-- select ltrim(' abc');
-- select rtrim('abc ');
-- select trim(' abc '); -- 공백제거(좌우만제거가능)
-- select trim(Both 'a' FROM 'aababaa');
-- select replace('It is banana banana','banana','apple');
-- select replace(trim(BOTH 'a' FROM 'aababaa'),'a','');
-- select replace(trim(both ' ' from ' a b c '),' ','');

select sal,hiredate,date_format(hiredate,'%Y')
from emp;
select max(sal), min(sal)
from emp;
select date_format(hiredate,'%Y'),max(sal),min(sal),count(sal)
from emp
group by date_format(hiredate,'%Y');

select deptno,max(sal) -- over(order by sal) max
from emp
where deptno >= 20
group by deptno;
