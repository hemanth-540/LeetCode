# Write your MySQL query statement below
select w.id from weather w where w.temperature > (
    select t.temperature from weather t where t.recordDate = date_sub(w.recordDate,interval 1 day)
);