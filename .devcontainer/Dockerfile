FROM ubuntu:22.04

# Prevent interactive prompts during package installation
ENV DEBIAN_FRONTEND=noninteractive

# Install required packages
RUN apt-get update && apt-get install -y \
    coreutils \
    bash \
    openjdk-17-jdk \
    unzip \
    wget \
    git \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Install Gradle manually
ENV GRADLE_VERSION=8.1
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip && \
    unzip gradle-${GRADLE_VERSION}-bin.zip -d /opt && \
    ln -s /opt/gradle-${GRADLE_VERSION}/bin/gradle /usr/local/bin/gradle && \
    rm gradle-${GRADLE_VERSION}-bin.zip

# Set up environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV GRADLE_HOME=/opt/gradle-8.1
ENV PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:${JAVA_HOME}/bin:${GRADLE_HOME}/bin

# Create a non-root user
RUN useradd -ms /bin/bash devuser
USER devuser
WORKDIR /workspaces

# Verify essential commands are in path
SHELL ["/bin/bash", "-c"]
RUN echo $PATH && \
    which sleep && \
    which java && \
    which gradle