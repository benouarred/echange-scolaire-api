#FROM alpine:latest
FROM openjdk:10
# some usefull tags
LABEL image-name docker-echange_scolaire-api
LABEL maintainer benouarred@gmail.com

#ENV JDK_VERSION="11.0.1"
#ENV JAVA_HOME="/jdk-11"
#ENV JDK_ARCHIVE="openjdk-11-GA_linux-x64-musl_bin.tar.gz"
#ENV PATH=$PATH:${JAVA_HOME}/bin

RUN echo "Downloading jdk build"
#RUN wget http://drive.jku.at/ssf/s/readFile/share/8207/4867522971216226929/publicLink/openjdk-11-GA_linux-x64-musl_bin.tar.gz

RUN echo "Downloading sha256 checksum"
#RUN wget http://drive.jku.at/ssf/s/readFile/share/8208/-1932052387783488162/publicLink/openjdk-11-GA_linux-x64-musl_bin.tar.gz.sha256

#RUN echo "Verify checksum"
#RUN sha256sum -c ${JDK_ARCHIVE}.sha256
#RUN echo "Checksum is correct"

#RUN echo "Extract JDK"
#RUN tar -xzf ${JDK_ARCHIVE}
# Remove downlaoded files
#RUN rm ${JDK_ARCHIVE} ${JDK_ARCHIVE}.sha256

#ENV JAVA_VERSION 11-ea+28
#ENV JAVA_ALPINE_VERSION 11~28-1

RUN echo $PATH