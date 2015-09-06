# BerkeleyCafeteria
Online cafeteria ordering and POS system

This is a simple online cafeteria ordering and POS system for a university that I created over the weekend. Registered students can log in and place orders using the available stores, and select a time they want to pick up their order upon checkout. They can also review past orders, and use these past orders in new orders as well. The Cashier user has a simlpe POS system to mark pending orders as "Picked Up" or "Missed" in addition to being able to place orders as well.

# Demo
A demo of the application is available <a href="http://ec2-52-11-74-160.us-west-2.compute.amazonaws.com/" target="_blank">here</a>.

*NOTE: If you are not logged into the application you will only be able to browse through the available store menus. Two sample users were created in the demo, a student and a cashier, in order to show functionality for those users. Credential for each User are below.

Student Username: Arun<br/>
Student Password: berkeley1234

Cashier Username: Cashier<br/>
Cashier Password: money1234

# Application Source Code

The code was written using the Groovy/Grails Framework, JavaScript (jQuery and Bootstrap), AJAX, and MySQL. A WAR file is included in the /target directory of the source code which can be deployed in tomcat. If you use the pre-built WAR file you need to have a MySQL database instance running on your localhost which has a root user without a password with an existing schema called "berkeleycafeteria". The schema can be empty, as the code is configured to automatically generate the schema if it doesn't exist, and add in some data to get you started. *NOTE This is not mean to be a production level system. There are certain things that I did not do like hashing of passwords, which should be done in production systems.

# Building the Application Yourself

If you want to build your own WAR file you must have Groovy configured on your system. Building your own WAR file allows you to configure your own options in the DataSource.groovy file for connecting to your own database.
