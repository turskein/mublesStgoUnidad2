# Node Alpine version -> light version
FROM node:16-alpine
WORKDIR /app

# Copiar paquete de dependencias
COPY package*.json ./
# Instalar dependencias
RUN npm install
RUN npm install -g serve

# Copiar archivos del proyecto a directorio /app en contenedor
COPY . .

EXPOSE 3000

CMD ["npm", "start"]