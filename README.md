
# Library Inventory API

This is a simple Spring Boot application that provides an API for managing a library's inventory. The API supports operations such as adding, deleting, and searching for books.

## Features

- Add a new book to the library
- Delete a book by ID or Title
- Search for books by year, title, or author
- Exception handling for duplicate book entries and book not found scenarios

## Endpoints

### 1. `POST /addBook`
Adds a new book to the library.

- **Request Body**:
  ```json
  {
      "bookId": 1,
      "title": "Book Title",
      "author": "Book Author",
      "year": 2025,
      "genre": "Drama"
  }
  ```
- **Response**:
  - Status: `202 ACCEPTED`
  - Body: `"Book Added Successfully!"`

- **Error**: If the book already exists (duplicate entry), the response will be:
  - Status: `400 BAD REQUEST`
  - Body: `"Book with title 'Book Title' already exists."`

### 2. `DELETE /deleteById`
Deletes a book from the library by its ID.

- **Request Parameters**:
  - `id` (int): The ID of the book to delete.

- **Response**:
  - Status: `202 ACCEPTED`
  - Body: `"Book deleted successfully."`

- **Error**: If no book is found with the given ID, the response will be:
  - Status: `400 BAD REQUEST`
  - Body: `"Book not found with ID 1"`

### 3. `DELETE /deleteByTitle`
Deletes a book from the library by its title.

- **Request Parameters**:
  - `title` (string): The title of the book to delete.

- **Response**:
  - Status: `202 ACCEPTED`
  - Body: `"Book deleted successfully."`

- **Error**: If no book is found with the given title, the response will be:
  - Status: `400 BAD REQUEST`
  - Body: `"Book not found with title 'Book Title'"`

### 4. `GET /search`
Searches for books in the library by year, title, or author.

- **Request Parameters**:
  - `year` (int): The year of the book.
  - `title` (string): The title of the book.
  - `author` (string): The author of the book.

- **Response**:
  - Status: `200 OK`
  - Body: A list of books matching the search criteria.

- **Error**: If no books are found matching the criteria, the response will be:
  - Status: `404 NOT FOUND`
  - Body: `"No books found matching the criteria"`

### 5. `GET /books`
Returns all books in the library.

- **Response**:
  - Status: `200 OK`
  - Body: A list of all books in the library.

- **Error**: If no books exist, the response will be:
  - Status: `404 NOT FOUND`
  - Body: `"No books found in the library"`

## Exception Handling

This API uses global exception handling with `@ControllerAdvice` to handle the following exceptions:

1. **DuplicateBookException**: Thrown when trying to add a book that already exists in the library.
2. **BookNotFoundException**: Thrown when trying to delete or search for a book that does not exist.

## Technologies Used

- Spring Boot
- Java
- Spring Web
- Spring Dependency Injection

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/library-inventory-api.git
   ```

2. Navigate into the project directory:
   ```bash
   cd library-inventory-api
   ```

3. Build the project:
   ```bash
   ./mvnw clean install
   ```

4. Run the project:
   ```bash
   ./mvnw spring-boot:run
   ```

5. The API will be available at `http://localhost:8080`.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
