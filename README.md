# BerkeleyCafeteria
Online cafeteria ordering and POS system

This is a simple online cafeteria ordering and POS system for a university that I created over the weekend. Registered students can log in and place orders using the available stores, and select a time for when they want to pick up their order during checkout. They can also review past orders, and use the items from these past orders in new orders as well. The Cashier user has a simlpe POS system to mark pending orders as "Picked Up" or "Missed" in addition to being able to place orders as well. 

# Demo
A demo of the application is available <a href="http://ec2-52-11-74-160.us-west-2.compute.amazonaws.com/" target="_blank">here</a>.

*NOTE: If you are not logged into the application you will only be able to browse through the available store menus. Two sample users were created in the demo, a student and a cashier, in order to show functionality for those users. Credentials for each User are below.

Student Username: Arun<br/>
Student Password: berkeley1234

Cashier Username: Cashier<br/>
Cashier Password: money1234

# Application Source Code

The code was written using the Groovy/Grails Framework, JavaScript (jQuery and Bootstrap), AJAX, and MySQL.

# Building the Application Yourself

If you want to build your own WAR file you must have Java (version 1.8), Groovy (2.3), and Grails (2.4.4) configured on your system. You can import the project into the Groovy Grails Tool Suite using the Import Grails Project and selecting the route to the Application directory as the Location of the Grails Project. Building your own WAR file allows you to configure your own options in the DataSource.groovy file for connecting to your own database. You will need to create a schema matching the name defined in DataSource.groovy. The schema can be empty, as the code is configured to automatically generate the tables if they do not exist, and add in some data (including users, stores, and items) to get you started. *NOTE This is only meant for demo purposes and not intended for use on a production level system. There are certain things that I did not do due to time constraints, like hashing passwords.

# Browser Compatibility

The application has been tested in Chrome, Firefox, IE, and Safari. The application has also been tested and is working with an iPad and Windows Surface.
