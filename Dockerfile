FROM gradle:8.4-jdk11

WORKDIR /Vacation-calculator

COPY . .

RUN gradle installDist

CMD ./build/install/Vacation-calculator/bin/Vacation-calculator

EXPOSE 8080