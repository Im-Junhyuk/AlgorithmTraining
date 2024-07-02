-- 코드를 입력하세요
SELECT BOOK_ID, DATE_FORMAT(published_date, '%Y-%m-%d') as 'PUBLISHED_DATE'
FROM book
WHERE category = '인문' AND YEAR(published_date) = 2021
ORDER BY published_date;