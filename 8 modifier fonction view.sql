CREATE OR REPLACE FUNCTION public.sauvegarde_temp_view() RETURNS trigger LANGUAGE plpgsql AS $function$
BEGIN
IF (new.id % 40) = 0 THEN
INSERT INTO public.view (moyenne_temp, timestamp) VALUES ((SELECT AVG(temp) FROM public.raw WHERE id >= (new.id - ((SELECT intake FROM params)-1))), current_timestamp);
INSERT INTO public.stats (min, max, intake, mod, med, moyenne, timestamp) VALUES (
    (SELECT over FROM params LIMIT 1),
    (SELECT under FROM params LIMIT 1),
	(SELECT intakes FROM params),
    (SELECT temp FROM raw WHERE id >= (new.id - ((SELECT intakes FROM params)-1)) GROUP BY raw.temp ORDER BY (SELECT COUNT(*) FROM raw WHERE id >= (new.id - ((SELECT intakes FROM params)-1))) DESC LIMIT 1),
    (SELECT temp FROM raw WHERE raw.id > ((SELECT MAX(id) FROM raw) - ((SELECT intakes FROM params)-1)) ORDER BY temp OFFSET (SELECT intakes FROM params)/2 LIMIT 1),
	(SELECT temp FROM public.raw where temp > (SELECT over FROM params LIMIT 1) and temp < (SELECT under FROM params LIMIT 1) order by id desc limit 40)/40,
    current_timestamp
);
END IF;
return new;
END
$function$