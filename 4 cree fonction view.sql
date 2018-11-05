CREATE OR REPLACE FUNCTION sauvegarde_temp_view()
RETURNS trigger AS 
$BODY$
BEGIN
IF (new.id % 100) = 0 THEN 
INSERT INTO public.view (moyenne_temp) VALUES (((SELECT SUM(temp) FROM public.raw WHERE id >= (new.id - 100))/100));
END IF;																						
return new;																					
END
$BODY$
LANGUAGE plpgsql;