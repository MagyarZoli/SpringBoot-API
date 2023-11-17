#!/usr/bin/env bash

#TARGET_JAR=$1
#
#if [ -z "$TARGET_JAR" ]; then
#  echo "Missing Target.jar file!";
#  exit 1
#fi

cd ..
java -version
mvn -version

mvn package
#java -jar target/"$TARGET_JAR"
java -jar target/api-0.0.1-SNAPSHOT.jar
