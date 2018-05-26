this example works with the mocked flavor (without using the real server) and the production flavor (using the real server)
in order to use the real server ->
    you must
    1) update the etrofit client with your ip (the ip of your ethernet hardware)
    public static final String BASE_URL = "http://<YOUR_IP>:8000";
    2) run the server the you can find in the root of the project -> python server.py
    3) connect the smartphone and the server's host to the same net

