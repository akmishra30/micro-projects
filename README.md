# Friends Management Project
This is the sample java based REST project using spring-boot framework. This project used in-memory h2 database. Following are APIs which exposed by this project.

1. As a user, I need an API to create a friend connection between two email addresses.
	API URI : /api/friends/add/connection, HTTP Method: PUT, Content-Typ: application/json
2. As a user, I need an API to retrieve the friends list for an email address.
	API URI : /api/friends/retrieve/list, HTTP Method: POST, Content-Typ: application/json
3. As a user, I need an API to retrieve the common friends list between two email addresses.
	API URI : /api/friends/retrieve/common, HTTP Method: POST, Content-Typ: application/json
4. As a user, I need an API to subscribe to updates from an email address.
	API URI : /api/friends/subscribe/updates, HTTP Method: PUT, Content-Typ: application/json
5. As a user, I need an API to block updates from an email address.
	API URI : /api/friends/block/updates, HTTP Method: DELETE, Content-Typ: application/json
6. As a user, I need an API to retrieve all email addresses that can receive updates from an email address.
	API URI : /api/friends/send/updates, HTTP Method: PUT, Content-Typ: application/json
