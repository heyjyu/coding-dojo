SELECT animal_type, COUNT(animal_type) AS count
FROM animal_ins
WHERE animal_type = 'Cat'
UNION
SELECT animal_type, COUNT(animal_type) AS count
FROM animal_ins
WHERE animal_type = 'Dog';
