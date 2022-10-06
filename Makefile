install:
	./gradlew clean install

# Run executable file (do this after install)
run-dist:
	./build/install/java-project-lvl2/bin/java-project-lvl2

# Run file with diff
run-diff-json:
	./build/install/java-project-lvl2/bin/java-project-lvl2 file1.json file2.json

run-diff-yml:
	./build/install/java-project-lvl2/bin/java-project-lvl2 file1.yml file2.yml

# Check updates for dependencies (libraries; plugins from build.gradle)
check-updates:
	./gradlew dependencyUpdates

# Compile project and run from console
run:
	./gradlew clean
	./gradlew run

# Check code-style
lint:
	./gradlew checkstyleMain

# Execute install tasks + another tasks
build:
	./gradlew clean build

# For Jacoco test coverage with CodeClimate in build-check.yml
test:
	./gradlew jacocoTestReport

.PHONY: build