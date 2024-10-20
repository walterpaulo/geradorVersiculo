FROM maven:3.8.4-openjdk-17 as BUILD

WORKDIR /workspace

COPY . /workspace

EXPOSE 8080

# RUN mvn clean install
# RUN mvn spring-boot:run
CMD [ "tail", "-f", "/dev/null" ]

