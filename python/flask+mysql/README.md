# Flask MVC Application Cheat Sheet

## Setting Up Flask

1. **Install Pipenv**:(No need if you already installed it)
    ```bash
    pip install pipenv
    ```

2. **Create and Activate Virtual Environment**:
    ```bash
    pipenv install flask pymysql
    pipenv shell
    ```

3. **Basic Flask Application Structure**:
    ```
    /flask_app
    ├── __init__.py
    ├── config
    │   └── mysqlconnection.py
    ├── controllers
    │   └── sample_controller.py
    ├── models
    │   ├── sample_model.py
    │   └── related_model.py
    ├── static
    │   ├── css
    │   │   ├── bootstrap.min.css
    │   │   └── style.css
    └── templates
        ├── add_form.html
        ├── items.html
        └── edit_form.html
    server.py
    ```

## Flask Application Components

### 1. `__init__.py`
- Initializes the Flask app and sets the secret key.
    ```python
    # filepath: /flask_app/__init__.py
    from flask import Flask
    app = Flask(__name__)
    app.secret_key = "YourSecretKey"
    ```

### 2. `mysqlconnection.py`
- Handles the connection to the MySQL database.
    ```python
    # filepath: /flask_app/config/mysqlconnection.py
    import pymysql.cursors

    class MySQLConnection:
        def __init__(self, db):
            connection = pymysql.connect(host='localhost',
                                         user='root',
                                         password='root',
                                         db=db,
                                         charset='utf8mb4',
                                         cursorclass=pymysql.cursors.DictCursor,
                                         autocommit=True)
            self.connection = connection

        def query_db(self, query, data=None):
            with self.connection.cursor() as cursor:
                try:
                    query = cursor.mogrify(query, data)
                    print("Running Query:", query)
                    cursor.execute(query)
                    if query.lower().find("insert") >= 0:
                        self.connection.commit()
                        return cursor.lastrowid
                    elif query.lower().find("select") >= 0:
                        result = cursor.fetchall()
                        return result
                    else:
                        self.connection.commit()
                except Exception as e:
                    print("Something went wrong", e)
                    return False
                finally:
                    self.connection.close()

    def connectToMySQL(db):
        return MySQLConnection(db)
    ```

### 3. `sample_model.py`
- Model for the sample table with methods for CRUD operations and validation.
    ```python
    # filepath: /flask_app/models/sample_model.py
    from flask import flash
    from flask_app.config.mysqlconnection import connectToMySQL
    from flask_app.models.related_model import RelatedModel

    class SampleModel:
        DB = "your_database_name"

        def __init__(self, data):
            self.id = data['id']
            self.name = data['name']
            self.created_at = data['created_at']
            self.updated_at = data['updated_at']
            self.related_items = []

        @classmethod
        def save(cls, data):
            query = """
            INSERT INTO sample_table (name)
            VALUES (%(name)s);
            """
            # return the id of the newly created record
            return connectToMySQL(cls.DB).query_db(query, data)

        @classmethod
        def get_all(cls):
            query = "SELECT * FROM sample_table;"
            results = connectToMySQL(cls.DB).query_db(query)
            samples = []
            for row in results:
                samples.append(cls(row))
            return samples

        @classmethod
        def get_by_id(cls, data):
            query = """
            SELECT * FROM sample_table
            LEFT JOIN related_table ON sample_table.id = related_table.sample_id
            WHERE sample_table.id = %(id)s;
            """
            results = connectToMySQL(cls.DB).query_db(query, data)
            sample = cls(results[0])
            for row in results:
                related_data = {
                    "id": row["related_table.id"],
                    "name": row["related_table.name"],
                    "sample_id": row["sample_id"],
                    "created_at": row["related_table.created_at"],
                    "updated_at": row["related_table.updated_at"]
                }
                sample.related_items.append(RelatedModel(related_data))
            return sample

        @classmethod
        def update(cls, data):
            query = """
            UPDATE sample_table SET
            name = %(name)s
            WHERE id = %(id)s;
            """
            return connectToMySQL(cls.DB).query_db(query, data)

        @classmethod
        def delete(cls, data):
            query = "DELETE FROM sample_table WHERE id = %(id)s;"
            return connectToMySQL(cls.DB).query_db(query, data)

        @staticmethod
        def validate(data):
            is_valid = True
            if len(data['name']) < 2:
                flash("Name must be at least 2 characters.", 'name')
                is_valid = False
            return is_valid
    ```

### 4. `related_model.py`
- Model for the related table with methods for CRUD operations.
    ```python
    # filepath: /flask_app/models/related_model.py
    from flask_app.config.mysqlconnection import connectToMySQL

    class RelatedModel:
        DB = "your_database_name"

        def __init__(self, data):
            self.id = data['id']
            self.name = data['name']
            self.sample_id = data['sample_id']
            self.created_at = data['created_at']
            self.updated_at = data['updated_at']

        @classmethod
        def save(cls, data):
            query = """
            INSERT INTO related_table (name, sample_id)
            VALUES (%(name)s, %(sample_id)s);
            """
            return connectToMySQL(cls.DB).query_db(query, data)

        @classmethod
        def get_all(cls):
            query = "SELECT * FROM related_table;"
            results = connectToMySQL(cls.DB).query_db(query)
            related_items = []
            for row in results:
                related_items.append(cls(row))
            return related_items

        @classmethod
        def get_by_id(cls, data):
            query = "SELECT * FROM related_table WHERE id = %(id)s;"
            result = connectToMySQL(cls.DB).query_db(query, data)
            return cls(result[0])

        @classmethod
        def update(cls, data):
            query = """
            UPDATE related_table SET
            name = %(name)s,
            sample_id = %(sample_id)s
            WHERE id = %(id)s;
            """
            return connectToMySQL(cls.DB).query_db(query, data)

        @classmethod
        def delete(cls, data):
            query = "DELETE FROM related_table WHERE id = %(id)s;"
            return connectToMySQL(cls.DB).query_db(query, data)
    ```

### 5. `sample_controller.py`
- Controller for handling routes and actions related to the sample model.
    ```python
    # filepath: /flask_app/controllers/sample_controller.py
    from flask import render_template, redirect, request
    from flask_app import app
    from flask_app.models.sample_model import SampleModel
    from flask_app.models.related_model import RelatedModel

    @app.route('/')
    def index():
        return redirect('/items')

    @app.route('/items')
    def items():
        all_items = SampleModel.get_all()
        return render_template('items.html', items=all_items)

    @app.route('/items/new')
    def new_item():
        return render_template('add_form.html')

    @app.route('/items/edit/<int:id>')
    def edit_item(id):
        item = SampleModel.get_by_id({'id': id})
        return render_template('edit_form.html', item=item)

    @app.route('/items/add', methods=['POST'])
    def add_item():
        if not SampleModel.validate(request.form):
            return render_template('add_form.html', form_data=request.form)
        SampleModel.save(request.form)
        return redirect('/items')

    @app.route('/items/update', methods=['POST'])
    def update_item():
        if not SampleModel.validate(request.form):
            return redirect(f'/items/edit/{request.form["id"]}')
        SampleModel.update(request.form)
        return redirect('/items')

    @app.route('/items/delete/<int:id>')
    def delete_item(id):
        SampleModel.delete({'id': id})
        return redirect('/items')

    @app.route('/related/add', methods=['POST'])
    def add_related_item():
        RelatedModel.save(request.form)
        return redirect(f'/items/edit/{request.form["sample_id"]}')
    ```

### 6. Templates
- HTML files for rendering the web pages.

#### `add_form.html`
- Form for adding a new item.
    ```html
    <!-- filepath: /flask_app/templates/add_form.html -->
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="{{ url_for('static', filename='css/bootstrap.min.css') }}">
        <title>Add Item</title>
    </head>
    <body>
        <div class="container">
            <h1>Add New Item</h1>
            <form action="/items/add" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" id="name" name="name" class="form-control" value="{{ form_data['name'] if form_data else '' }}">
                    {% for message in get_flashed_messages(category_filter=["name"]) %}
                    <em class="text-danger">{{ message }}</em>
                    {% endfor %}
                </div>
                <button class="btn btn-primary">Add</button>
            </form>
        </div>
    </body>
    </html>
    ```

#### `edit_form.html`
- Form for editing an existing item and adding related items.
    ```html
    <!-- filepath: /flask_app/templates/edit_form.html -->
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="{{ url_for('static', filename='css/bootstrap.min.css') }}">
        <title>Edit Item</title>
    </head>
    <body>
        <div class="container">
            <h1>Edit Item</h1>
            <form action="/items/update" method="post">
                <input type="hidden" name="id" value="{{ item.id }}">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" id="name" name="name" class="form-control" value="{{ item.name }}">
                    {% for message in get_flashed_messages(category_filter=["name"]) %}
                    <em class="text-danger">{{ message }}</em>
                    {% endfor %}
                </div>
                <button class="btn btn-primary">Update</button>
            </form>
            <h2>Related Items</h2>
            <form action="/related/add" method="post">
                <input type="hidden" name="sample_id" value="{{ item.id }}">
                <div class="mb-3">
                    <label for="related_name" class="form-label">Related Item Name</label>
                    <input type="text" id="related_name" name="name" class="form-control">
                </div>
                <button class="btn btn-secondary">Add Related Item</button>
            </form>
            <ul>
                {% for related_item in item.related_items %}
                <li>{{ related_item.name }}</li>
                {% endfor %}
            </ul>
        </div>
    </body>
    </html>
    ```

#### `items.html`
- Displays all items.
    ```html
    <!-- filepath: /flask_app/templates/items.html -->
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="{{ url_for('static', filename='css/bootstrap.min.css') }}">
        <title>Items</title>
    </head>
    <body>
        <div class="container">
            <h1>Items</h1>
            <a href="/items/new" class="btn btn-primary">Add New Item</a>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {% for item in items %}
                    <tr>
                        <td>{{ item.name }}</td>
                        <td>
                            <a href="/items/edit/{{ item.id }}" class="btn btn-warning">Edit</a>
                            <a href="/items/delete/{{ item.id }}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                    {% endfor %}
                </tbody>
            </table>
        </div>
    </body>
    </html>
    ```

## Command to run the app

- **Run the Flask app**:
    ```bash
    py server.py
    ```

## Tips for Building a Full-Stack CRUD App

1. **Understand the MVC Pattern**: Know how models, views, and controllers interact in a Flask application.
2. **Database Operations**: Be familiar with CRUD operations and how to connect to a MySQL database.
3. **Form Handling and Validation**: Understand how to handle form submissions and validate input data.
4. **Flask Flash Messages**: Know how to use flash messages for displaying validation errors and other messages to the user.
5. **Routing**: Be comfortable with defining routes and handling different HTTP methods (GET, POST).



## Implementing One-to-Many Relationships

1. **Define the Relationship in Models**: Ensure that the parent model (e.g., `SampleModel`) has a list to hold related items and that the child model (e.g., `RelatedModel`) has a foreign key to the parent model.
2. **Update the Controller**: Add routes and methods to handle creating and displaying related items.
3. **Update Templates**: Modify the templates to include forms and displays for related items.

## Additional Resources
### Understand how joins work in SQL
- [Spathon](https://joins.spathon.com/)

Good luck with your Exam!
