.PHONY: build

run-dist:
	./build/install/java-project-lvl2/bin/java-project-lvl2

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

report:
	./gradlew jacocoTestReport
