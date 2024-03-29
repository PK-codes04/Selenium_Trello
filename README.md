The goal is to generate automated test scripts with Selenium to comprehensively assess the critical features of the Trello application.
 Tasks:

1.	Test Scenario Identification:

1.	Key Features of Trello:

1.	User Authentication: To use Trello, users must register themselves by providing valid email followed by email verification. Users can only login with correct credentials. This authentication ensures that only authorized users can see their workspaces.
2.	Create and Manage Board: Trello allows user to create and manage board with features like change visibility, rename, invite other members to join the board and delete board.
3.	List and Card creation: User can create lists and tasks within the list which helps them to organize work. User can add details to the card like description, comments, due dates etc. And move card from one list to another by drag and drop. List comes with an archive feature which helps user to archive the list once tasks are completed. Typically list starts with default “To Do," "Doing," and "Done" lists, and you can add more as needed.
4.	Workspace for teams: User can create dedicated workspace and invite other members where they can collaborate. Team members in same workspace can comment and update progress in the tasks. Admin can change the privacy of the workspace, add or remove the team members and delete workspace once work is completed.
5.	Notifications: Users will get notify with mentions, due date reminders and board activities.
6.	Search and Filtering: User can search the board, cards and members. User have filter option to narrow down search results.
7.	User profile management: User can update personal information and profile visibility and manage account settings.
8.	Trello Templates: Trello templates are pre-designed boards with lists and cards, often tailored for specific purposes or common use cases. They are a convenient way for Trello users to kickstart their projects and workflows without having to create boards and lists from scratch.
9.	Activity Information: User can see all the activities performed by user profile including login history.
10.	Logout: User can logout securely with all work saved in his profile with logout option.


2.	Critical test scenarios and functionalities to be tested using Selenium:


No.	Test Scenario	Functionality
1.	Verify that user can successfully login with valid credentials into Trello account. (Login Happy Path)
	



  User Login
2.	Verify that user cannot login with invalid password.	
3.	Verify that user cannot login with blank password.	
4.	Verify that user can successfully login and logout with valid credentials. (Login Logout Happy Path)	
5.	Verify that user can create board with required information. (Board Creation Happy Path)	

Create and Manage Board
6.	Verify that user can change board visibility.	
7.	Verify that user can delete the board. (Board Deletion).	
8.	Verify that user cannot sign up with blank email Id.	

    Sign Up
9.	Verify that user cannot sign up with invalid email Id.	
10.	Verify that user can sign up with valid email Id. (Sign Up Happy path)	
11.	Verify that user can create list with card. (List and Card Creation Happy Path)	


Create and Manage List and Card 
12.	Verify that user can update the card with description details and comment.	
13.	Verify that user can archive the selected list.	
14.	Verify that user can create workspace with required information. (Workspace Creation Happy Path)	
Create and Manage Workspace

15.	Verify that user can change workspace visibility.	
16.	Verify that user can invite workspace members.	
Create and Manage Workspace

17.	Verify that user can delete the workspace.	
![image](https://github.com/PK-codes04/Selenium_Trello/assets/165342691/13d07235-8cf8-42a9-86d2-68350b5c561d)
