# seyon1988-LibraryManagementSystem

This Project is submitted for OUSL as an Assignment for job.

This is project is about library management system.


Sample Admin Login
Username - lib
password - lib

sample Student Login
Username/Email - stu
password - stu


Assumptions
-----------
Librarian Also can borrow books

User cannot register himself admin has to add him
When user added by admin
their will be an user id auto generated (serial type integer)
User will be given a printed id card, with above mentioned ID number
When user borrowing or returing the book user will bring the ID card (for getting  user's id number)
So filtering out user from whole user list becomes an easier task
(otherwise librarian should select the user from whole user list by scrolling down)

Similarly when adding literatures also an user id auto generated (serial type integer)
It will be written on the literature
So filtering out book from whole book list becomes an easier task (for getting literature's id number)
(otherwise librarian should select the literature from whole literature list)

Steps for running app
----------------------
1. postgress sql installation and database restortion
2. Running the back end
3. Running the front end
4. Running web app in vbrowser

1.Installing postgress and restoring database
----------------------------------------------
First we should install postgress sql

then create a database as 
databasename=librarymanagementsystem

then create a user as
username = seyon
password = seyon

assign full rights to seyon for database librarymanagementsystem
after restore the database file "DB_Backup"


2.Back end running
--------------------
Install maven
open terminal inside root folder 
of backend "LibraryManagementSystemBackEnd"

Build Spring Boot Project by using one below commands
mvn install
if you want clean first then build use
mvn clean install

After Building run it by
mvn spring-boot:run


3.Front end running
--------------------
Install NodeJs
Install Angular_CLI
open terminal inside root folder 
of frontend "librarymanagement-frontend"


4.Running webapp in Browser
---------------------------
open browser and travel to below url
(copy & paste in address bar)
http://localhost:4200


Versions
---------
Angular: 11.2.12
Spring Boot : v2.4.5

Any inquires
-----------
Mobile - 0770224064

Email - seyon1988@gmail.com


Thank you!

Seyon

