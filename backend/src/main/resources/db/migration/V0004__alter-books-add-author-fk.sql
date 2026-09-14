alter table books
    drop column author,
    add column author_id integer null,
    add constraint fk_books_author
         foreign key (author_id) references authors(id);