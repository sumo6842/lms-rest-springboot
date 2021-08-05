package com.ojt.lms.server.service.document;

import com.ojt.lms.server.model.dto.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class QuestionServiceTest {
    @Autowired
    QuestionService service;

    List<Question> questionList = Arrays.asList(
            new Question("You can determine all the keys in a Map in which of the following ways?", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question("What keyword is used to prevent an object from being serialized?", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question("An abstract class can contain methods with declared bodies.", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question("Select the order of access modifiers from least restrictive to most restrictive.", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question("Which access modifier allows you to access method calls in libraries not created in Java?", "Option A","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question(" Which of the following statements are true? (Select all that apply.)", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question("The keyword extends refers to what type of relationship?", "Option A", "Option A".getBytes(StandardCharsets.UTF_8)),
            new Question(" Which of the following keywords is used to invoke a method in the parent class?", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question(" What is the value of x after the following operation is performed? x = 23 % 4;", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question(" Which of the following expressions results in a positive value in x?", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question(" Which of the following operations might throw an ArithmeticException?", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question("Which of the following operations might throw an ArithmeticException?", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8)),
            new Question(" Which of the following may appear on the left-hand side of an instanceof operator?", "Option A", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate".getBytes(StandardCharsets.UTF_8))
    );

    @Test
    void getQuestionFromQuizBanking() {
        service.getQuestionToQuiz(1)
            .ifPresent(System.out::println);
    }

    @Test
    void getFromSubject() {
        service.getQuestionFromSubject(2L)
                .ifPresent(System.out::println);
    }

    @Test
    void createOrUpdateQuestion() {
        questionList
                .forEach(u -> service.createOrUpdateQuestion(2L,1, u));
    }

    @Test
    void retrieveById() {
    }

    @Test
    void deleteQuiz() {
    }
    /**

     (38, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'5. Which of the following may appear on the right-hand side of an instanceof operator?', 1)
     (39, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'6. What is -50 >> 1?', 1)
     (40, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'7. Which of the following statements is true?', 1)
     (41, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'8. Which modifier or modifiers should be used to denote a variable that should not be written out as part of its class''s persistent state? (Choose the shortest possible answer.)', 1)
     (42, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'9. Which of the following statements are true?', 1)
     (43, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'10. Which of the following statements are true?', 1)
     (44, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'11. Which of the following statements is correct? (Choose one.)', 1)
     (45, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'12. Which of the following statements is true? (Choose one.)', 1)
     (46, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'13. Which of the following may legally appear as the new type (between the parentheses) in a cast operation?', 1)
     (47, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'14. Which of the following may legally appear as the new type (between the parentheses) in a cast operation?', 1)
     (48, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'15. Suppose the type of xarr is an array of XXX, and the type of yarr is an array of YYY. When is the assignment xarr = yarr; legal?', 1)
     (49, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'16. When is x & y an int? (Choose one).', 1)
     (50, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'17. What are the legal types for whatsMyType?
     short s = 10; whatsMyType = !s;', 1)
     (51, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'18. When a negative long is cast to a byte, what are the possible values of the result?', 1)
     (52, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'19. What is the difference between the rules for method-call conversion and the rules for assignment conversion?', 1)
     (53, 2, CAST(N'2021-07-21' AS Date), N'SE111111', N'20. When is it appropriate to pass a cause to an exception''s constructor?', 1)
     (54, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'1. Which of the following should always be caught?', 1)
     (55, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'2. When does an exception''s stack trace get recorded in the exception object?', 1)
     (56, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'3. When is it appropriate to write code that constructs and throws an error?', 1)
     (57, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'4. Which of the following may override a method whose signature is void xyz(float f)?', 1)
     (58, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'5. Suppose x and y are of type TrafficLightState, which is an enum. What is the best way to test whether x and y refer to the same constant?', 1)
     (59, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'6. Which of the following restrictions apply to anonymous inner classes?', 1)
     (60, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'7. Which methods return an enum constant''s name?', 1)
     (61, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'8. Suppose class X contains the following method:
     void doSomething(int a, float b) { ... }

     Which of the following methods may appear in class Y, which extends X?', 1)
     (62, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'9. Which of the following methods in the Thread class are deprecated?', 1)
     (63, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'10. Which of the following statements about threads is true?', 1)
     (64, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'11. Which of the following statements about the wait() and notify() methods is true?', 1)
     (65, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'12. How many locks does an object have?', 1)
     (66, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'13. How do you prevent shared data from being corrupted in a multithreaded environment?', 1)
     (67, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'14. How can you ensure that multithreaded code does not deadlock?', 1)
     (68, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'15. Suppose you want to write a class that offers static methods to compute hyperbolic trigonometric functions. You decide to subclass java.lang.Math and provide the new functionality as a set of static methods. Which one statement is true about this strategy?', 1)
     (69, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'16. Which of the following classes implement java.util.List?', 1)
     (70, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'17. Suppose you are writing a class that will provide custom serialization. The class implements java.io.Serializable (not java.io.Externalizable). What access mode should the writeObject() method have?', 1)
     (71, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'18. Suppose you are writing a class that will provide custom deserialization. The class implements java.io.Serializable (not java.io.Externalizable). What access mode should the readObject() method have?', 1)
     (72, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'19. Suppose class A extends Object; class B extends A; and class C extends B. Of these, only class C implements java.io.Serializable. Which of the following must be true in order to avoid an exception during deserialization of an instance of C?', 1)
     (73, 3, CAST(N'2021-07-21' AS Date), N'SE111111', N'20. Suppose class A extends Object; Class B extends A; and class C extends B. Of these, only class C implements java.io.Externalizable. Which of the following must be true in order to avoid an exception during deserialization of an instance of C?', 1)
     (74, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'1. Why so JavaScript and Java have similar name?', 1)
     (75, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'2. When a user views a page containing a JavaScript program, which machine actually
     executes the script?', 1)
     (77, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'3. ______ JavaScript is also called client-side JavaScript.', 1)
     (78, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'4. __________ JavaScript is also called server-side', 1)
     (79, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'5. What are variables used for in JavaScript Programs?', 1)
     (80, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'6. _____ JavaScript statements embedded in an HTML page can respond to user events
     such as mouse-clicks, form input, and page navigation.', 1)
     (81, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'
     7.
     What should appear at the very end of your JavaScript?
     The <script LANGUAGE="JavaScript">tag', 1)
     (82, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'8. Which of the following can''t be done with client-side JavaScript?', 1)
     (83, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'9. Which of the following are capabilities of functions in JavaScript?', 1)
     (84, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'10. Which of the following is not a valid JavaScript variable name?', 1)
     (85, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'11. ______ tag is an extension to HTML that can enclose any number of JavaScript
     statements.', 1)
     (86, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'12. How does JavaScript store dates in a date object?', 1)
     (87, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'13. Which of the following attribute can hold the JavaScript version?', 1)
     (88, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'14. What is the correct JavaScript syntax to write "Hello World"?', 1)
     (89, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'15. Which of the following way can be used to indicate the LANGUAGE attribute?', 1)
     (90, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'16. Inside which HTML element do we put the JavaScript?', 1)
     (91, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'17. What is the correct syntax for referring to an external script called " abc.js"?', 1)
     (92, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'18. Which types of image maps can be used with JavaScript?', 1)
     (93, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'19. Which of the following navigator object properties is the same in both Netscape and
     IE?', 1)
     (94, 6, CAST(N'2021-07-21' AS Date), N'SE111111', N'20. Which is the correct way to write a JavaScript array?', 1)
     (95, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'1. What does the <noscript> tag do?', 1)
     (96, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'2. If para1 is the DOM object for a paragraph, what is the correct syntax to change the
     text within the paragraph?', 1)
     (97, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'3. JavaScript entities start with _______ and end with _________.', 1)
     (98, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'4. Which of the following best describes JavaScript?', 1)
     (99, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'
     5. Choose the server-side JavaScript object?', 1)
     (100, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'
     6. Choose the client-side JavaScript object?', 1)
     (101, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'7. Which of the following is not considered a JavaScript operator?', 1)
     (102, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'8. ______method evaluates a string of JavaScript code in the context of the specified
     object.', 1)
     (103, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'9. Which of the following event fires when the form element loses the focus: <button>,
     <input>, <label>, <select>, <textarea>?', 1)
     (104, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'10. The syntax of Eval is ________________', 1)
     (105, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'
     11. JavaScript is interpreted by _________', 1)
     (106, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'12. Using _______ statement is how you test for a specific condition.', 1)
     (107, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'13. Which of the following is the structure of an if statement?', 1)
     (108, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'14. How to create a Date object in JavaScript?', 1)
     (109, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'15. The _______ method of an Array object adds and/or removes elements from an
     array.', 1)
     (110, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'16. To set up the window to capture all Click events, we use which of the following
     statement?', 1)
     (111, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'
     17. Which tag(s) can handle mouse events in Netscape?', 1)
     (112, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'18. ____________ is the tainted property of a window object.', 1)
     (113, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'19. To enable data tainting, the end user sets the _________ environment variable.', 1)
     GO
     (114, 5, CAST(N'2021-07-21' AS Date), N'SE111111', N'20. In JavaScript, _________ is an object of the target language data type that encloses
     an object of the source language.', 1)
     (115, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'
     1. When a JavaScript object is sent to Java, the runtime engine creates a Java wrapper
     of type ___________', 1)
     (116, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'2. _______ class provides an interface for invoking JavaScript methods and examining
     JavaScript properties.', 1)
     (117, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'3. _________ is a wrapped Java array, accessed from within JavaScript code.', 1)
     (118, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'4. A ________ object is a reference to one of the classes in a Java package, such as
     netscape.javascript .', 1)
     (119, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'
     5. The JavaScript exception is available to the Java code as an instance of __________', 1)
     (120, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'6. To automatically open the console when a JavaScript error occurs which of the
     following is added to prefs.js?', 1)
     (121, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'7. To open a dialog box each time an error occurs, which of the following is added to
     prefs.js?', 1)
     (122, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'8. The syntax of a blur method in a button object is ______________', 1)
     (123, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'9. The syntax of capture events method for document object is ______________', 1)
     (124, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'10. The syntax of close method for document object is ______________', 1)
     (125, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'11. The following syntax to set margin around a paragraph will make- p{margin:10px 2%}', 1)
     (126, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'12. The ...................... property allows you to control the shape or style of bullet point in the case of unordered lists, and the style of numbering characters in ordered list.', 1)
     (127, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'13. The ......................... property allows to specify the distance between the list and the text relating to the list.', 1)
     (128, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'14. The ...................... property allows to specify how much space appear between the content of an element and it''s border.', 1)
     (129, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'15. State True or False for CSS outlines properties.

     i) An outline does take up space

     ii) Outline do not have to be rectangular.

     iii) Outline is always the same on all sides.', 1)
     (130, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'
     16. The overflow property in CSS can take one of the following values.

     i) visible ii) hidden iii) scroll iv) non-scroll v) auto', 1)
     (131, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'17. Which of the following is/are the valid syntax for CSS pseudo classes.', 1)
     (132, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'18. The valid examples of ID selectors is/are', 1)
     (133, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'19. Which of the following is/are the possible values of CSS pseudo element property?

     i) : first line ii) : last-line iii) : before iv) : after v) : between', 1)
     (134, 4, CAST(N'2021-07-21' AS Date), N'SE111111', N'20.
     The ............... rule is used to make sure that the property always be applied whether another property appears in CSS.', 1)
     */

}