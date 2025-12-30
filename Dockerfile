FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

RUN javac src/*.java

CMD ["java", "-cp", "src", "Main"]

