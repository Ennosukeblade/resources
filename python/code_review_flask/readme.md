# Flask Task Manager


## Overview
This Flask application allows users to:
- View all tasks
- Add tasks
- View individual tasks
- Delete tasks

Tasks are stored in the **Flask session**

![Task Manager Screenshot](todo_list.png)
---

## Routes Overview

### Home Page
**Route:** `/`
- Displays all tasks.
- Form to add a task.

### Add Task
**Route:** `/add_task` (POST)
- Accepts form data to create a new task with a unique ID.
- Redirects back to the home page after submission.

### View a Task
**Route:** `/tasks/<id>`
- Retrieves and displays details of a specific task using its ID.

### Delete a Task
**Route:** `/tasks/<id>/delete`
- Deletes a task based on its ID.
- Redirects back to the home page.

