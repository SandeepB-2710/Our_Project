package com.tata.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}







//To know about this code read the explanation below.

/*
Why we need this :

We need the ErrorDetails class to provide a clear, consistent, and structured error response 
whenever an exception occurs in the application. It helps clients and developers understand 
what went wrong, when it happened, and which request caused it, instead of returning confusing or 
unstructured error messages.


This ErrorDetails class is a simple data container whose main purpose is to describe error information in a 
clean and structured way whenever something goes wrong in the application. Instead of sending random or 
confusing error messages to the client, this class helps the application send a clear, meaningful, and consistent 
error response.

The class belongs to the com.tata.exception package, which already tells us its responsibility: 
it is related to exception and error handling. This means it does not contain business logic, database logic, 
or API logic. Its only job is to hold error-related data.

Inside the class, there are three fields. The first field, time stamp, stores the exact date and time when 
the error occurred. This is very useful for debugging and logging because it helps developers know when a 
problem happened. For example, if an error occurs at 10:15 AM, the time stamp captures that moment so it can 
be traced later in logs.

The second field, message, stores the actual error message. This is usually a human-readable description of 
what went wrong, such as “Post not found with id 999”. This message helps both developers and API consumers 
quickly understand the cause of the error without digging into server logs.

The third field, details, stores additional information about the error, usually related to the request itself. 
In your project, this typically contains the API path (for example, /api/post/999). This helps identify 
which API call caused the error, which is extremely useful when multiple APIs exist in the system.

The @Getter annotation from Lombok automatically generates getter methods for all the fields. This means 
you don’t have to manually write methods like getTimestamp(), getMessage(), or getDetails(). Lombok does 
that for you at compile time, keeping your code clean and readable.

The @AllArgsConstructor annotation also comes from Lombok and automatically creates a constructor that 
accepts all three fields as parameters. This makes it very easy to create an ErrorDetails object in one line, 
especially inside the Global Exception Handler. Instead of setting each field manually, you can simply pass the 
timestamp, message, and details when the error occurs.

In the overall flow of your project, this class is used by the Global Exception Handler to build a structured 
JSON response whenever an exception is thrown. When an error happens, Spring uses this class to return a response 
that includes the time of error, a clear message, and the request details. This results in a professional, 
standardized error response that follows real-world REST API best practices.

In simple terms, you can think of ErrorDetails as an error report object. Whenever something goes wrong, 
the application fills in this report and sends it back to the client so they know exactly what happened, 
when it happened, and where it happened.
 */
