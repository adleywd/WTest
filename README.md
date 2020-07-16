### The Test

The First Menu is the form. It has only the email validation.

In the article option, app uses retrofit to get the data from URL, then GSon convert the JSON objects to Objects(POJO).
I've been using this objects in a custom recycler view list. For now, it only shows the first page from the endpoint  (page 1, limit 10).
When one item from the list is clicked, the app pass through intent the serialized selected object and start a new activity.
In the new activity the data is bind to user view, using a nested scroll list to attach the image to the top of the screen.

### Third-Party Libraries
* [Picasso by Square Open Source] (http://square.github.io/picasso/)
* [Retrofit by Square Open Source] (https://square.github.io/retrofit/)
* [GSon by Google] (https://github.com/google/gson)