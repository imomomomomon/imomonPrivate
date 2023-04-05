-- 직업이 salesman이 아닌 사원들의 이름, 월급,커미션,
-- 월급+커미션을 출력하시요

-- 직업, 직업별 토탈월급을 출력하는데, 직업별 토탈월급이
-- 4000이상인것만 출력하시오

-- 최대월급을 받는 사원의 이름과 월급을 출력하시요

-- 입사동기별 최대연봉을 받는 사람의 정보 출력 

use scott;
/*
select ENAME, SAL + ifnull(comm,0) 'SAL+COMM'
from emp
where job != 'salesman';
*/

/*
select job, sum(sal)
from emp
group by job
having sum(sal) > 3000;
*/

/*
select ename, sal
from emp
where sal = (select max(sal) from emp);
*/

/*
select date_format(hiredate,'%Y'), group_concat(ename), max(sal)
from emp
group by date_format(hiredate,'%Y');
*/


select * from employees;
select * from departments; 

-- ex1)employees테이블의 모든 사원의 사원번호(employee_id),이름(last_name),급여(salary) 검색
select employee_id, last_name, salary
from employees;

-- ex2)employees테이블에서 모든 사원의 이름, 입사일(hire_date), 업무ID(job_id)만 검색
select last_name, hire_date,job_id
from employees;

-- ex3)employees테이블에서 모든 사원의 이름(last_name), 연봉(salary*12)만 검색
select last_name, format(salary*12,0)
from employees;

-- ex4)별명붙이기(as는 생략가능)
--    employees테이블의 모든 사원의 사원번호,이름(last_name),급여 검색
--    조건) title 사원번호, 이름 ,급여로 출력할것

select employee_id as number,last_name as name, format(salary,0) salary
from employees;

-- ex5)employee테이블에서 사원번호,이름,연봉을 구하시오
--     조건1) 연봉 = 급여 * 12
--     조건2) 제목을 사원번호,이  름,연  봉으로 출력

select employee_id as '사원번호',last_name as '이름', format(salary*12,0) as '연봉'
from employees;


-- ex6)연결연산자(concat): 컬럼을 연결해서 출력
--    first_name과  last_name을 연결해서 출력하시오
--     이   름
--     ------------
--     Ellen   Abel
-- 일반적인 DBMS에서는 ||로 문자열을 연결하지만 MySQL에서는 ||을 사용할수 없다. 
-- concat()사용해야 한다.

select concat(first_name,' ',last_name)
from employees; 

-- ex7)다음처럼 출력하시오
--   사원번호        이  름                 연 봉
--   ---------------------------------------------
--    100      Steven King   288000달러 
select employee_id as '사원번호', 
concat(first_name,' ',last_name) as '이름' ,
concat(format(salary,0),'달러') as '연봉'
from employees;

-- ex8) 다음처럼 출력하시오 (last_name, job_id이용)
--     Employee  Detail
--     --------------------
--     King  is a  AD_PRES
select concat(last_name,' is a ',job_id) as 'Employee Detail'
from employees;

-- 중복제거(distinct)
-- ex9)employees테이블에서 부서를 출력하시오
--    조건1)중복되는 부서는 1번만 출력하시오
--    조건2)부서별 오름차순으로 보여주시오

select department_name
from departments
where department_id in(select distinct department_id from employees)
order by department_name;

-- ex10) 10번부서 또는 90번부서 사원들의 이름,입사일,부서ID를 출력하시오
-- 방법1)or 연산자

select last_name, hire_date, department_id
from employees
where department_id = 10 or department_id = 90;

-- 방법2)in연산자(or연산자의 다른표현)

select last_name, hire_date, department_id
from employees
where department_id  in(10,90);

-- ex11)급여가 2500이상 3500이하인 사원의 이름(last_name), 입사일, 급여를 검색하시오 --33건
-- 방법1)and 연산자

select last_name,hire_date,salary
from employees
where salary >= 2500 and salary <= 3500;

-- 방법2)between연산자(and연산자의 다른 표현): 초과,미만에서는 사용할수 없다

select last_name,hire_date,salary
from employees
where salary between 2500 and 3500;

-- ex12) 급여가 2500이하 이거나 3000이상이면서, 90번 부서인 사원의 이름, 급여, 부서ID를 출력하시오. --3건
--      조건1) 제목은 사원명, 월  급, 부서코드로 하시오
--      조건2) 급여앞에 $를 붙이시오
--      조건3) 사원명은 first_name과 last_name을 연결해서 출력하시오

select concat(first_name,' ',last_name) as '사원명',
concat('$',format(salary,0)) as '월급',
department_id as '부서코드'
from employees
where (salary <= 2500 or salary >= 3500) and department_id = 90;

-- ex14)업무ID에 CL이 포함되어있는 사원들의 이름,업무ID,부서ID를 출력하시오  --45건


-- ex15)업무ID가  IT로 시작하는 사원들의 이름,업무ID,부서ID를 출력하시오  -- 5건

select e.last_name,e.department_id, d.location_id, d.department_name
from employees e join departments d
using (department_id)
where substring(d.department_name,1,2) = 'IT'; 


-- ex16) is null / is not null 
-- 커미션을 받는 사원들의 이름과 급여,커미션을 출력하시오 -- 35건

select last_name, salary, commission_pct
from employees
where commission_pct is not null;

-- ex17)커미션을 받지 않는 사원들의 이름과 급여,커미션을 출력하시오 -- 72건

select last_name, salary, commission_pct
from employees
where commission_pct is null;

-- ex18) 사원명,부서ID,입사일을 부서별로 내림차순 정렬하시오

select e.last_name,e.department_id, e.hire_date, d.department_name
from employees e join departments d
using (department_id)
order by d.department_name;

-- ex19) 사원명, 부서ID, 입사일을  부서별로 내림차순 정렬하시오
--     같은부서가 있을때는  입사일순으로 정렬하시오

select e.last_name,e.department_id, e.hire_date, d.department_name
from employees e join departments d
using (department_id)
order by d.department_name, e.hire_date;

-- ex20) 사원들의 연봉을 구한후 연봉순으로 내림차순정렬하시오   
-- 이 름     연 봉     
-- ---------------
-- King   28800달러

select last_name, format(salary*12,0) as '연봉'
from employees
order by '연봉';

-- Data Manipulation Language (DML) : SELECT
-- [형식]
-- case [value] when  표현식  then  구문1
--              when  표현식  then  구문2
--                       :
--              else  구문3
-- end

-- ex21)업무 id가 'SA_MAN'또는'SA_REP'이면 'Sales Dept' 그 외 부서이면 'Another'로 표시
-- 조건) 분류별로 오름차순정렬
--        직무          분류
--       --------------------------
--       SA_MAN    Sales Dept
--       SA_REP      Sales Dept
--       IT_PROG    Another



-- ex22) 급여가 10000미만이면 초급, 20000미만이면 중급 그 외이면 고급을 출력하시오 
--      조건1) 컬럼명은  '구분'으로 하시오
--      조건2) 제목은 사원번호, 사원명, 구  분
--      조건3) 구분(오름차순)으로 정렬하고, 구분값이 같으면 사원명(오름차순)으로 정렬하시오

select employee_id as 사원번호 ,last_name as 사원명,
case salary
when salary < 10000 then '초급'
when salary < 20000 then '중급'
else '고급'
end as 구분,
salary
from employees;