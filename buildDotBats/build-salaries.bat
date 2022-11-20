cd ../micro-services/salaries-service && mvn clean package -DskipTests && docker build . -t alexpachecolaos/salaries-image && docker push alexpachecolaos/salaries-image
