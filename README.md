# Friends Management Project

This is the sample java based REST project using spring-boot framework. 

**1. As a user, I need an API to create a friend connection between two email addresses.**

	API URI : http(s)://{host}:{port}/api/friends/add/connection, HTTP Method: PUT, Content-Typ: application/json

Request Payload:

```
{
  friends:
    [
      'andy@example.com',
      'john@example.com'
    ]
}
```

Success Response: 200 OK

```
{
  "success": true
}
```

Invalid payload or fields validation failure response: 400 BAD REQUEST

```
{
    "errorRef": "68b50b29-f7d8-4b12-bc17-186ec96cc312",
    "timestamp": "2018-06-13T14:09:16.412+0800",
    "message": "Request payload is failed in validation. Please see details.",
    "details": {
        "fieldErrors": [
            {
                "field": "friends",
                "code": "Size",
                "invalidValue": [
                    "xyz@gmail.com"
                ],
                "message": "You have to provide two email addresses to find common friends."
            }
        ],
        "objectErrors": []
    }
}
```

Resource not found response: 404 NOT FOUND

```
{
    "timestamp": 1528870345316,
    "status": 404,
    "error": "Not Found",
    "exception": "com.sp.group.firends.management.exception.FriendProfileNotFoundException",
    "message": "[abcd@gmail.com, xyz@gmail.com] profile(s) were not found.",
    "path": "/api/friends/add/connection"
}
```

**2. As a user, I need an API to retrieve the friends list for an email address.**

	API URI : http(s)://{host}:{port}/api/friends/retrieve/list, HTTP Method: POST, Content-Typ: application/json
	
	
Request Payload:

```
{
  "email": "abc@gmail.com"
}
```

Success Response: 200 OK

```
{
    "success": true,
    "friends": [
        "def@gmail.com",
        "pqr@gmail.com"
    ],
    "count": 2
}
```

Invalid payload or fields validation failure response: 400 BAD REQUEST

```
{
    "errorRef": "50003957-3c9b-45af-9b01-ade2fa4e515d",
    "timestamp": "2018-06-13T14:16:02.068+0800",
    "message": "Request payload is failed in validation. Please see details.",
    "details": {
        "fieldErrors": [
            {
                "field": "email",
                "code": "Email",
                "invalidValue": "abc.com",
                "message": "Invalid email format."
            }
        ],
        "objectErrors": []
    }
}
```

Resource not found response: 404 NOT FOUND

```
{
    "timestamp": 1528870596680,
    "status": 404,
    "error": "Not Found",
    "exception": "com.sp.group.firends.management.exception.FriendProfileNotFoundException",
    "message": "Given friend is not available.",
    "path": "/api/friends/retrieve/list"
}
```

**3. As a user, I need an API to retrieve the common friends list between two email addresses.**

	API URI : http(s)://{host}:{port}/api/friends/retrieve/common, HTTP Method: POST, Content-Typ: application/json
	
	
Request Payload:

```
{
  "friends":
    [
      "abc@gmail.com",
      "pqr@gmail.com"
    ]
}
```

Success Response: 200 OK

```
{
    "success": true,
    "friends": [
        "def@gmail.com"
    ],
    "count": 1
}
```

Invalid payload or fields validation failure response: 400 BAD REQUEST

```
{
    "errorRef": "a6c69d64-b8ae-4b73-b1df-a956c3ffede8",
    "timestamp": "2018-06-13T14:18:42.782+0800",
    "message": "Request payload is failed in validation. Please see details.",
    "details": {
        "fieldErrors": [
            {
                "field": "friends",
                "code": "Size",
                "invalidValue": [],
                "message": "You have to provide two email addresses to find common friends."
            }
        ],
        "objectErrors": []
    }
}
```

Resources not found response: 404 NOT FOUND

```
{
    "timestamp": 1528870773353,
    "status": 404,
    "error": "Not Found",
    "exception": "com.sp.group.firends.management.exception.FriendProfileNotFoundException",
    "message": "[abcf@gmail.com, pqrf@gmail.com] profile(s) were not found.",
    "path": "/api/friends/retrieve/common"
}
```

**4. As a user, I need an API to subscribe to updates from an email address.**

	API URI : http(s)://{host}:{port}/api/friends/subscribe/updates, HTTP Method: PUT, Content-Typ: application/json
	
	
Request Payload:

```
{
  "requestor": "abc@gmail.com",
  "target": "xyz@gmail.com"
}

```

Success Response: 200 OK

```
{
  "success": true
}
```

Invalid payload or fields validation failure response: 400 BAD REQUEST

```
{
    "errorRef": "8b88cd91-ba7a-4812-bc8f-44668b4e2c1a",
    "timestamp": "2018-06-13T14:21:54.883+0800",
    "message": "Request payload is failed in validation. Please see details.",
    "details": {
        "fieldErrors": [
            {
                "field": "target",
                "code": "Email",
                "invalidValue": "mail.com",
                "message": "not a well-formed email address"
            },
            {
                "field": "requestor",
                "code": "Email",
                "invalidValue": "abcgmail.com",
                "message": "not a well-formed email address"
            }
        ],
        "objectErrors": []
    }
}
```

Resource not found response: 404 NOT FOUND

```
{
    "timestamp": 1528870886540,
    "status": 404,
    "error": "Not Found",
    "exception": "com.sp.group.firends.management.exception.FriendProfileNotFoundException",
    "message": "[abcd@gmail.com, xyzd@gmail.com] profile(s) were not found.",
    "path": "/api/friends/subscribe/updates"
}
```

**5. As a user, I need an API to block updates from an email address.**

	API URI : http(s)://{host}:{port}/api/friends/block/updates, HTTP Method: DELETE, Content-Typ: application/json
	
	
Request Payload:

```
{
 "requestor": "abc@gmail.com",
  "target": "xyz@gmail.com"
}
```

Success Response: 200 OK

```
{
  "success": true
}
```

Invalid payload or fields validation failure response: 400 BAD REQUEST

```
{
    "errorRef": "cc5f03fd-78f9-49cb-b13b-257bf78a398b",
    "timestamp": "2018-06-13T14:23:49.865+0800",
    "message": "Request payload is failed in validation. Please see details.",
    "details": {
        "fieldErrors": [
            {
                "field": "target",
                "code": "NotEmpty",
                "invalidValue": null,
                "message": "target field should not be empty or null."
            },
            {
                "field": "requestor",
                "code": "NotEmpty",
                "invalidValue": null,
                "message": "requestor field should not be empty or null."
            }
        ],
        "objectErrors": []
    }
}
```

Resource not found response: 404 NOT FOUND

```
{
    "timestamp": 1528871004500,
    "status": 404,
    "error": "Not Found",
    "exception": "com.sp.group.firends.management.exception.FriendProfileNotFoundException",
    "message": "[abqc@gmail.com, xyzq@gmail.com] profile(s) were not found.",
    "path": "/api/friends/block/updates"
}
```

**6. As a user, I need an API to retrieve all email addresses that can receive updates from an email address.**

	API URI : http(s)://{host}:{port}/api/friends/send/updates, HTTP Method: PUT, Content-Typ: application/json
	
	
Request Payload:

```
{
  "sender":  "abc@gmail.com",
  "text": "Hello World! kate@example.com"
}
```

Success Response: 200 OK

```
{
    "success": true,
    "recipients": [
        "kate@example.com",
        "pqr@gmail.com",
        "def@gmail.com"
    ]
}
```

Invalid payload or fields validation failure response: 400 BAD REQUEST

```
{
    "errorRef": "c7d828f2-ae27-4dd3-9fff-c6d0c8e57c57",
    "timestamp": "2018-06-13T14:25:32.970+0800",
    "message": "Request payload is failed in validation. Please see details.",
    "details": {
        "fieldErrors": [
            {
                "field": "text",
                "code": "NotEmpty",
                "invalidValue": null,
                "message": "text field should not be empty or null."
            }
        ],
        "objectErrors": []
    }
}
```

Resource not found response: 404 NOT FOUND

```
{
    "timestamp": 1528870345316,
    "status": 404,
    "error": "Not Found",
    "exception": "com.sp.group.firends.management.exception.FriendProfileNotFoundException",
    "message": "[abcd@gmail.com, xyz@gmail.com] profile(s) were not found.",
    "path": "/api/friends/add/connection"
}
```


