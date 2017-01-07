# Moodle glossary converter
Allows you to convert a glossary exported from [Moodle learning platform] into an open-question test in GIFT-format. Such test could be then imported into question bank of some moodle course.

## Building and launching converter
For building you will need:
* [JDK 1.8]
* [Maven]

Download and extract repositry files, change to /glos2gift dir:
```sh
 cd ./glos2gift/
```
Build app by using maven and start the gotten jar-file:
```sh
mvn install
cd ./target/glo2gift
java -jar glo2gift.jar
```

[JDK 1.8]:<http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>
[Maven]:<https://maven.apache.org/download.cgi>
[Moodle learning platform]: <https://docs.moodle.org/32/en/About_Moodle>

