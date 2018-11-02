create table if not exists word_count
(
  word VARCHAR(100) not null,
  date DATE not null,
  count int not null
);
