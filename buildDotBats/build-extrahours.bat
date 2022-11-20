cd ../micro-services/uploadextrahours-service && mvn clean package -DskipTests && docker build . -t alexpachecolaos/uploadextrahours-image && docker push alexpachecolaos/uploadextrahours-image
