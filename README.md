[![Codacy Badge](https://app.codacy.com/project/badge/Grade/177eb89c17a3428e809f610548cee97e)](https://www.codacy.com/gh/tkoppop/Create-Jobs/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=tkoppop/Create-Jobs&amp;utm_campaign=Badge_Grade)
# My Personal Project

## A quick overview

The application so far will be a simple task planner with a monthly calender, a daily plan, and a todo list. 
You will be able to add and remove tasks that you need to do with ease, and have many difference GUIs to choose from. 
This program will feature a monthly view, a weekly view, and a daily view, with a todo list task bar to the side. 
Additionally you can shrink this planner so that you can only be a miniature version of the todo list.

This program is targeted towards students, or people with many tasks to complete daily. I will personally use this 
as my main task organizer when this project is completed.

This project interests me as I personally use many different planners to keep track of my projects. However everything
I have found online has often disappointed me in terms of its functionality and "premium" features. I have not found an 
application that allows me to turn on monthly, weekly, daily, and a todo list view at the same time, and to change and 
customize those views at will. Additionally, most of these planners require payment to unlock full functionality, 
I really want to make something simple and I can use. 

#User Stories
As a user, I want to be able to add tasks to my todo-list

As a user, I want to be able to remove tasks to my todo-list

As a user, I want to be able to sort my tasks based on urgency

As a user, I want to be able to see what tasks I have scheduled in my todo-list 

As a user, I want to be able to have a quick way to access a Calendar.

As a user, I want to be able to save my todo list

As a user, I want to be able to load my todo list from last session

You can generate the First Required Event by adding a task, and entering all the fields clicking the add task, then
hitting submit. Go to View chooser and click todo list. Click refresh, and the task you made is there.

You can generate the Second Required Event by removing a task. Highlight the entire todo list entry and hit finish. 
This will remove the task from your list, and fullfilled the requirement.

You can trigger my audio component by finishing and removing tasks from my list. IF you make a task, goto todo list and
highlight and click finish. A audio queue will trigger, fullfilling requirement 3.

you can generate the fourth requirement by adding a task, then clicking save at the bottom of view chooser. The file is 
called calender.txt, and there willl be the saved file.

you can generate the fifth requirement by previously saving a file, then click load file on the View chooser. Go to the
todo list, and click refresh. You will see that your tasks have loaded. Thus, fullfilling the fifth requirement.

##Phase 4: Task 2
I have chosen to add robustness to my program, specifically the remove task method in my Calender Class. Originally, it 
required that the task being removed was actually in the Calender, but now it throws a TaskNotFoundExpection if the task
isn't found. The tests that were excepted and not excepted were added in the CalenderTest Class. Specifically, the 
testAddMultiple was the test that doesn't expect the exception, and testAddMultipleTaskNotFound is the one that excepts
it.

##Phase 4: Task 3
ViewChooser class was doing too many things. It was supposed to load UI to choose what the planner does, but It also
Loaded and Saved Calenders. To fix this, I moved LoadCalender and SaveCalender into their own classes to increase 
cohesion. 

The View Chooser class was also my main function, which did almost everything in my program. This was fixed simply by
a Main class, with a main function that launched viewChooser to increase Cohesion.
