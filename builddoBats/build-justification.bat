cd ../micro-services/uploadjustification-service && mvn clean package -DskipTests && docker build . -t alexpachecolaos/uploadjustification-image && docker push alexpachecolaos/uploadjustification-image
