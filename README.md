# RoomDb

## Architechture components

A new collection of libraries that help you design robust, testable, and maintainable apps.

Keep in mind that mobile devices are resource constrained, so at any time, the operating system may need to kill some apps to make room for new ones. The point of all this is that your app components can be launched individually and out-of-order, and can be destroyed at anytime by the user or the system. Because app components are ephemeral and their lifecycle (when they are created and destroyed) are not under your control, you should not store any app data or state in your app components and your app components should not depend on each other.

The new architecture has following components that make it easy. They are also designed to fit together as building blocks.

## Room

Room is designed to abstract away the underlying database tables and queries, and encourage best-practice development patterns on Android.

By default, Room doesn't allow you to issue database queries on the main thread to avoid poor UI performance. 

The core framework provides built-in support for working with raw SQL content. Although these APIs are powerful, they are fairly low-level and require a great deal of time and effort to use:

There is no compile-time verification of raw SQL queries.

As your schema changes, you need to update the affected SQL queries manually. This process can be time consuming and error prone.

You need to write lots of boilerplate code to convert between SQL queries and Java data objects.

Room takes care of these concerns for you while providing an abstraction layer over SQLite.

## Database, Entity, DAO

There are three major components in Room:

1. Entity represents data for a single table row, constructed using an annotated java data object. Each entity is persisted into its own table. Represents a table within the database.

2. DAO (Data Access Object) defines the method that access the database, using annotation to bind SQL to each method. (Contains the methods used for accessing the database.)

3. Database is a holder class that uses annotation to define the list of entities and database version. This class content defines the list of DAOs.

The class that's annotated with @Database should satisfy the following conditions:

1. Be an abstract class that extends RoomDatabase.
2. Include the list of entities associated with the database within the annotation.
3. Contain an abstract method that has 0 arguments and returns the class that is annotated with @Dao.

At runtime, you can acquire an instance of Database by calling Room.databaseBuilder() or Room.inMemoryDatabaseBuilder().

-> The app uses the Room database to get the data access objects, or DAOs, associated with that database. 

-> The app then uses each DAO to get entities from the database and save any changes to those entities back to the database. 

-> Finally, the app uses an entity to get and set values that correspond to table columns within the database.

#### Note: If your app runs in a single process, you should follow the singleton design pattern when instantiating an AppDatabase object. Each RoomDatabase instance is fairly expensive, and you rarely need access to multiple instances within a single process.

#### If your app runs in multiple processes, include enableMultiInstanceInvalidation() in your database builder invocation. That way, when you have an instance of AppDatabase in each process, you can invalidate the shared database file in one process, and this invalidation automatically propagates to the instances of AppDatabase within other processes.

In given example, Room automatically converts POJO object into corresponding database tables and back again.

## Checks SQLite at compile time

Room also checks SQLite at compile time so if you spell something wrong or reference a column that is not into database it can show warnings at compile time like below

Error: There is a problem with the query: [SQLITE_ERROR] SQL error or missing database (no such table: commentsZ)

LiveData can easily be used with Room to monitor the changes in database. Room will create a the live data object observing the database.

@Query(“SELECT * FROM comments WHERE id = :userId”)
LiveData load(String userId);

