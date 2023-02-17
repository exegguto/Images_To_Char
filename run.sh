#!/bin/bash
clear
mkdir ./target ./target/com

cd target ; jar xf ../lib/JColor-5.5.1.jar com ; jar xf ../lib/jcommander-1.82.jar com ; cd ..

cp -r src/resources target/.
javac  -cp ".:./lib/JColor-5.5.1.jar:./lib/jcommander-1.82.jar"  -d ./target/ src/java/edu.school21.printer/*/*.java

jar cvfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .
java -jar ./target/images-to-chars-printer.jar --white=RED --black=GREEN