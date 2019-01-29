#se descarga ubuntu como base
FROM ubuntu:16.04

#se agrega el repositorio mongodb para apt
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927
RUN echo "deb http://repo.mongodb.org/apt/ubuntu $(cat /etc/lsb-release | grep DISTRIB_CODENAME | cut -d= -f2)/mongodb-org/3.2 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-3.2.list

#se instala mongodb, nodejs, supervisor
RUN apt-get -y update && apt-get -y install mongodb-org supervisor nodejs build-essential npm

# se crea el directorio de datos de mongodb, de logs de supervisor y para la pagina de todolist
RUN mkdir -p /data/db
RUN mkdir -p /var/log/supervisord
RUN mkdir -p /var/www

#se copia la configuracion de supervisor para que inicie mongo y la pagina
COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf

#se copia la pagina
COPY todolist /var/www 

#se cambia el directorio de trabajo
WORKDIR /var/www

#se expone el puerto de la pagina
EXPOSE 8090

#se instalan las dependencias de la pagina
RUN npm install

# se inicializa supervisor como ejecutable al iniciar el contenedor
CMD /usr/bin/supervisord -c /etc/supervisor/conf.d/supervisord.conf






