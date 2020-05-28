# MyNewsFeedApp 3rd-version
In this version we will perform an HTTP request using Async task to make a request to the internet and get the requested data from the https link provided.

1. Setup permissions in AndroidManifest.xml to give the phone an internet connection.
2. Create an AsyncTask inner class in the Main activity class to perform a background thread.
3. Remove the String JSON_RESPONSE from ther QueryUtils, this will be replaces bu the http url in the Main Activity.
