# BUG or Feaure?

Yada does not verify post parameters, if no body is submitted.

# How to reproduce

Clone this repo and start the server with `clj -m main`.

Now send a request with:

    curl -X POST "http://localhost:8080"

This should return a 400 bad request error. Instead,
yada returns a normal 200 response, with this body:

     <h1>Hello, null !</h1>

I am not sure whether this is a bug or a feature. Both
1.2.15 and 1.2.16 have this behavior.

