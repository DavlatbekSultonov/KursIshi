# 1. Java 21 va Maven bilan boshlaymiz
FROM maven:3.9.6-eclipse-temurin-21 AS build

# 2. Ishchi katalogni yaratamiz
WORKDIR /app

# 3. Maven konfiguratsiyasini avval nusxalaymiz (kechani optimallashtirish uchun)
COPY pom.xml .

# 4. Maven dependencies (keshni tezlashtirish uchun)
RUN mvn dependency:go-offline

# 5. Loyihaning barcha fayllarini nusxalaymiz
COPY src src

# 6. Maven orqali loyihani build qilamiz (testlarsiz)
RUN mvn clean package -DskipTests

# 7. Faqat Java 21 image-ga o‘tamiz (runtime uchun)
FROM openjdk:21

# 8. Ishchi katalogni yaratamiz
WORKDIR /app

# 9. Build qilingan JAR faylni nusxalaymiz
COPY --from=build /app/target/*.jar app.jar

# 10. Port ochish (8080)
EXPOSE 8080

# 11. Ilovani ishga tushirish
ENTRYPOINT ["java", "-jar", "app.jar"]
