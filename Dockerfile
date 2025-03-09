# 1. Java 21 va Maven bilan boshlaymiz
FROM maven:3.9.6-eclipse-temurin-21 AS build

# 2. Ishchi katalogni yaratamiz
WORKDIR /app

# 3. Barcha fayllarni konteynerga nusxalaymiz
COPY src .

# 4. Maven orqali loyihani build qilamiz (testlarsiz)
RUN mvn clean package -DskipTests

# 5. Faqat Java 21 image-ga o‘tamiz (runtime uchun)
FROM openjdk:21

# 6. Ishchi katalogni yaratamiz
WORKDIR /app

# 7. Yaratilgan JAR faylni olish
COPY --from=build /app/target/*.jar app.jar

# 8. Port ochish (8282)
EXPOSE 8080

# 9. Ilovani ishga tushirish
ENTRYPOINT ["java", "-jar", "app.jar"]
