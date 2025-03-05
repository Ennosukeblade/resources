# Flask Task Manager - Setup & Usage

## Overview
This Flask application allows users to:
- Add tasks
- View individual tasks
- Delete tasks

Tasks are stored in the **Flask session**, meaning they persist only for the session duration.

---

## Environment Setup
### Prerequisites
Ensure you have:
- Python (>= 3.6)
- Flask installed

### Installation Steps
1. Clone or download the repository.
2. Navigate to the project directory.
3. Install Flask using:
   ```bash
   pip install flask
   ```

### Running the Application
Start the Flask app by executing:
```bash
python app.py
```
Access the application at **http://127.0.0.1:5000/**.

---

## Routes Overview

### Home Page
**Route:** `/`
- Displays all tasks.
- Generates a unique ID for each session.

### Add Task
**Route:** `/add_task` (POST)
- Accepts form data to create a new task.
- Redirects back to the home page after submission.

### View a Task
**Route:** `/tasks/<id>`
- Retrieves and displays details of a specific task using its ID.

### Delete a Task
**Route:** `/tasks/<id>/delete`
- Deletes a task based on its ID.
- Redirects back to the home page.

---

## Key Discussion Points
- **Flask session usage** for storing tasks.
- **Handling missing task IDs** gracefully.
- **Possible improvements**, such as using a database instead of session storage.

**Best,**  
Mouadh

