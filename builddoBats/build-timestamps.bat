cd ../micro-services/uploadtimestamps-service && mvn clean package -DskipTests && docker build . -t alexpachecolaos/uploadtimestamps-image && docker push alexpachecolaos/uploadtimestamps-image
