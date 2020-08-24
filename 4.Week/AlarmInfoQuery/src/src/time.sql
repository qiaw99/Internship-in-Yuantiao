SELECT
	date_format(
		DATATIME, 
		'%Y-%m-%d %H:%i'
	) as CALL_TIME,
	infoa.AREA_NAME as DEPARTMENT,
	ar.`NAME` as LOCATION,
	ar.ALARM_TYPE
	FROM
		alarm_result AS ar,
		info_r2a AS info,
		info_area AS infoa 
	WHERE
		ar.ID = info.roadid 
		AND DATATIME >= "2017-06-28 20:55"
		AND DATATIME <= "2017-06-28 21:55"
		AND ar.`NAME` LIKE '%香樟%'
		AND info.areaid = infoa.ID 
		AND ( AREA_NAME = "雨花区" OR AREA_NAME = "芙蓉区" OR AREA_NAME = "天心区" 
		OR AREA_NAME = "岳麓区" OR AREA_NAME = "开福区" OR AREA_NAME = "高新区" ) 