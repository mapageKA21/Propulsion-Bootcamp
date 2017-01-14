# Basics of networking

This will be a short introduction to Internet Networking. Mainly focused on what happens in the browser. Which is also called the 'client'.

### Requests

The internet works with HTTP Requests. HTTP is a request/response protocol between two connected devices.

The most common case is when you enter a url in the browser. This is the beginning of a chain of requests and responses.

Usually the first would be an HTML file. However, this HTML file usually makes more request.

Each CSS, image, Javascript file that you require in your HTML is a request.

### Browser

The Browser handles all those requests and their responses for us.

Based on those files, the browser executes the code in them and creates the UI that we see.

### Types of HTTP Requests

There are 4 main types of HTTP request:

- GET
- POST
- PUT / PATCH
- DELETE

**GET**

This request is used to retrieve files or data from the server.

Example: `www.google.com` or when you require a CSS file from the HTML.

**POST**

When you want the request to save something new in the server. Usually in a database.

Example: When you want to register for an application. You click "like" on a picture.

**PUT / PATCH**

The request will update some resource in the server. Usually in a database.

Example: You edit your profile

**DELETE**

You want to remove something that was stored in the server.

Example: When you remove a tweet. - Or this is how it should be done...-

### Response and Status

The browser makes the requests. The server sends the response to that request.

The response can be a data with a string format or a whole file for example.

In order to help the browser read the response. The response have Status. They go in hundreds. Each specific hundred has a meaning:

- 1xx: Informational
- 2xx: Success
- 3xx: Redirection
- 4xx: Client error. Maybe the url you click does not exist. Remember the typical 404.
- 5xx: Server error. There was an error in the server while trying to give you the response.

[Here](https://httpstatuses.com/) you have a list of the statuses.

[Here](https://twitter.com/stevelosh/status/372740571749572610) a joke / simple explanation in a tweet.
