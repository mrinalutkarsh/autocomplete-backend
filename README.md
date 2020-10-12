# autocomplete-backend
## Docker
1) ``` docker pull mrinalutkarsh/autocomplete_mrinal:latest ```
2) ``` docker run -p 9090:9090 mrinalutkarsh/autocomplete_mrinal:latest ```
3) ``` curl --request GET 'http://localhost:9090/search/ban' ```
4) API response is a list of cities starting with the key. ('ban' in the above case)

## Using Jar
1) Download the jar
2) Run ``` java -jar autocomplete.jar & ```
3) ``` curl --request GET 'http://localhost:9090/search/ban' ```
4) API response is a list of cities starting with the key. ('ban' in the above case)