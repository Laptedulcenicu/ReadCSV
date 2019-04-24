# ReadCSV
instructions to run the code:
1) Set where is located Interview-task-data-osh.csv you can find in Main1 class
2) Set where will be created bad-data-timestamp.csv you can find  in Main1 class
3) Set where will be created statistics.log you can find in Main1 class
4) Set where will be created X.db you can find in conn class

To solve the challange i used three libraries:
a. sqlite-jdbc-3.27.2.1
b. opencsv-4.5
c. commons-lang3-3.6

Opencsv,  commons-lang3-3.6  helped me to open,read and write csv file  and sqlite-jdbc driver helped me to work with database.
Opencsv has the possibility automatic to detect a comma and to double qouted a element.
While I read the Interview-task-data-osh.csv I verifaied if it contains at least  an empty row , if it was true than data is written in bad-data-timestamp.csv and after this begin a new iteration, but is is not true the data is written in sqlite database.
The statistics was written in statistics.log
To insert faster the data in sqlite data base i used transaction. 
