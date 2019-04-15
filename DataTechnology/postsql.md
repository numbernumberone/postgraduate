--join update
UPDATE tr_police_hotel_checkin  AS v 
SET stay_days = s.stay_days
FROM tr_police_hotel_checkin_test1 AS s
WHERE v.nbbh = s.nbbh and 
v.zklsh = s.zklsh  
