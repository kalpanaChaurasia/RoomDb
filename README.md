# RoomDb

The core framework provides built-in support for working with raw SQL content. Although these APIs are powerful, they are fairly low-level and require a great deal of time and effort to use:
There is no compile-time verification of raw SQL queries.

As your schema changes, you need to update the affected SQL queries manually. This process can be time consuming and error prone.

You need to write lots of boilerplate code to convert between SQL queries and Java data objects.

Room takes care of these concerns for you while providing an abstraction layer over SQLite.

## Database, Entity, DAO

There are three major components in Room:

1. Entity represents data for a single table row, constructed using an annotated java data object. Each entity is persisted into its own table.

2. DAO (Data Access Object) defines the method that access the database, using annotation to bind SQL to each method.

3. Database is a holder class that uses annotation to define the list of entities and database version. This class content defines the list of DAOs.
