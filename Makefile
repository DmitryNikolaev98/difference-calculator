run-dist:
	./build/install/java-project-lvl2/bin/java-project-lvl2 src/test/resources/file1.json src/test/resources/file2.json

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

lint:
	./gradlew checkstyleMain
test:
	./gradlew test
