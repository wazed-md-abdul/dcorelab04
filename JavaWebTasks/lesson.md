# Java Web Servlet Lesson

This document briefs you on how to implement basic Servlets as requested by your Java Web tasks.

## 1. ChineseServlet Implementation

This task demonstrates how to handle character encoding in a Servlet to ensure Chinese characters are displayed correctly in the browser.

### Key Learnings:
- **`HttpServlet`**: All Servlets must extend this class.
- **`doGet()`**: This method handles HTTP GET requests.
- **`response.setContentType("text/html;charset=UTF-8")`**: This is crucial. It tells the browser that the content is HTML and that the character encoding is UTF-8. Without this, Chinese characters might appear as garbled text (mojibake).
- **`response.getWriter()`**: This method returns a `PrintWriter` that allows you to write the HTML response body directly to the client.

## 2. ShowTimesServlet Implementation

This task demonstrates how to manage state across user requests using the `ServletContext`.

### Key Learnings:
- **`ServletContext`**: This object represents the web application's shared environment. Any data stored in the `ServletContext` (via `setAttribute`) is accessible by all Servlets in the same web application context and persists as long as the application is running.
- **`doPost()` to `doGet()` redirection**: It's a common practice to have `doPost` call `doGet` when the logic for both request types is identical (in this case, just displaying the count).
- **Attribute Management**:
    - `getAttribute("name")`: Retrieve an object previously stored in the context.
    - `setAttribute("name", value)`: Store an object in the context.
- **Thread Safety Note**: In a real production environment, accessing `ServletContext` attributes from multiple threads (multiple concurrent users) might require synchronization to avoid race conditions when incrementing the count.

## How to Compile and Run
To run these Servlets, you need a Servlet Container (like Apache Tomcat).
1. Create a Dynamic Web Project in an IDE like IntelliJ IDEA or Eclipse.
2. Put these files in the `src/main/java` directory under their package structure (`com.example`).
3. Deploy the application to your Tomcat server.
4. Access the URLs defined by `@WebServlet("/...")`, e.g., `http://localhost:8080/yourappname/chinese`.
