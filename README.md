# RoomDb

## Architechture components

A new collection of libraries that help you design robust, testable, and maintainable apps.

Keep in mind that mobile devices are resource constrained, so at any time, the operating system may need to kill some apps to make room for new ones. The point of all this is that your app components can be launched individually and out-of-order, and can be destroyed at anytime by the user or the system. Because app components are ephemeral and their lifecycle (when they are created and destroyed) are not under your control, you should not store any app data or state in your app components and your app components should not depend on each other.

The new architecture has following components that make it easy. They are also designed to fit together as building blocks.

## Room

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

In given example, Room automatically converts POJO object into corresponding database tables and back again.

## Checks SQLite at compile time

Room also checks SQLite at compile time so if you spell something wrong or reference a column that is not into database it can show warnings at compile time like below

Error: There is a problem with the query: [SQLITE_ERROR] SQL error or missing database (no such table: commentsZ)


