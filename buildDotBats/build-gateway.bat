cd ../micro-services/gateway-service && mvn clean package -DskipTests && docker build . -t alexpachecolaos/gateway-image && docker push alexpachecolaos/gateway-image
