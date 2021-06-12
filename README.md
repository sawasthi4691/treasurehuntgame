About the Project :

It consists of two APIs 

1. It take the inputs and store in redis cache. Input value are as follows:
		a. User id - ( to uniquely identified the user)
  		b. Board Game value 5x5 array
		
		Rest API url - localhost:8080/input
		PostMan input Sample -
		{
		"user-id" : "15",
		"treasure-map" : {
			  "1" : [34 , 21 , 32 , 41 ,25],
			  "2" : [14 , 42 , 43 , 14 ,31],
			  "3" : [54 , 45 , 52 , 42,  23  ],
			  "4" : [33 , 15 , 51 , 31 , 35  ],
			  "5" : [21 , 52 , 33 , 13 , 23  ]

			}
		}
2. Its show the output of the treasure hunt game.

	Rest API url - localhost:8080/output/{userId}
	
	PostMan output Sample -
	[
	    "11 : Row Visited!!!",
	    "34 : Row Visited!!!",
	    "42 : Row Visited!!!",
	    "15 : Row Visited!!!",
	    "25 : Row Visited!!!",
	    "31 : Row Visited!!!",
	    "54 : Row Visited!!!",
	    "13 : Row Visited!!!",
	    "32 : Row Visited!!!",
	    "45 : Row Visited!!!",
	    "35 : Row Visited!!!",
	    "23 : Row Visited!!!",
	    "43 : Row Visited!!!",
	    "51 : Row Visited!!!",
	    "21 : Row Visited!!!",
	    "14 : Row Visited!!!",
	    "41 : Row Visited!!!",
	    "33 : Row Visited!!!",
	    "52 : Row Visited!!!",
	    "52 : Treasure Found!!!"
	]															
	
Before starting the application, we need to start redis server to store the data.Redis zip file is given with project. Just unzip it and run redis-server file.


Technical Coding Exercise  - Description

		   +-------------------------+
                  ¦ 34 ¦ 21 ¦ 32 ¦ 41 ¦ 25  ¦
                  +----+----+----+----+-----¦
                  ¦ 14 ¦ 42 ¦ 43 ¦ 14 ¦ 31  ¦
                  +----+----+----+----+-----¦
                  ¦ 54 ¦ 45 ¦ 52 ¦ 42 ¦ 23  ¦
                  +----+----+----+----+-----¦
                  ¦ 33 ¦ 15 ¦ 51 ¦ 31 ¦ 35  ¦
                  +----+----+----+----+-----¦
                  ¦ 21 ¦ 52 ¦ 33 ¦ 13 ¦ 23  ¦
                  +-------------------------+
                        

Do you like treasure hunts? In this problem you are to write a program to explore the above array for a treasure. The values in the array are clues. Each cell contains an integer between 11 and 55; for each value the ten's digit represents the row number and the unit's digit represents the column number of the cell containing the next clue. Starting in the upper left corner (at 1,1), use the clues to guide your search of the array. (The first three clues are 11, 34, 42). The treasure is a cell whose value is the same as its coordinates. Your program must first read in the treasure map data into a 5 by 5 array. Your program should output the cells it visits during its search, and a message indicating where you found the treasure.

Instructions
•	The above exercise needs to be completed within 1 day and reply back to everyone once it is completed
•	Please reply back if you have any doubts to proceed further
•	Please follow the best OOPS coding principles like DRY, SRP, KISS, DIP,ISP, LSP
•	Develop using Java frameworks and design patterns
•	Develop as a API using Springboot and deploy as a containerless apps
•	Develop using TDD approach 
•	Upload the code in your personal GitHub and share the link for review
•	Please provide comments and naming conventions for better understanding



