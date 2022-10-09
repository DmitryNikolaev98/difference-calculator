install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app -h

run-diff-json:
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

run-diff-yml:
	./build/install/app/bin/app src/test/resources/file1.yml src/test/resources/file2.yml

check-updates:
	./gradlew dependencyUpdates

run:
	./gradlew clean
	./gradlew run

lint:
	./gradlew checkstyleMain

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

.PHONY: build