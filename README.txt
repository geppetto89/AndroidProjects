You can run the backend server by running "python server.py".  This will make the server available on http://localhost:8000.  To fetch data, first request the root page (http://localhost:8000) to get the correct path:

This will return a json object with one key "next_path", which details the endpoint to retrieve the response code from (note the next_path changes with every request).  An example response is:
{"next_path": "http://localhost:8000/d/"}

The app can then fetch the url provided in "next_path" and retrieve the response code, An example response is:
{"path": "d","response_code": "8f26843d-581d-40cb-9e81-aeccd9727902"}

If the app attempts to request a "next_path" value that isn't the last one to be returned by the server, the server will respond with an error:
{"error": "App requested the wrong path, expected: d"}

The server will print the current "next_path" and "response_code" values to the console, which can be used to confirm the app is performing correctly.