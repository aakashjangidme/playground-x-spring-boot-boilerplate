APP_NAME='playground-x-server-spring-boot'
IMAGE_NAME:=aakashjangidme/$(APP_NAME)
IMAGE_TAG:=latest

default:
	cat ./Makefile

dist:
	./mvnw clean package

image:
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .

run:
	docker run -p 9000:9000 -it --rm $(IMAGE_NAME):$(IMAGE_TAG) --name="$(APP_NAME)"

run-bash:
	docker run -p 9000:9000 -it --rm $(IMAGE_NAME):$(IMAGE_TAG) --name="$(APP_NAME)" /bin/bash

clean:
	docker image rm -f $(IMAGE_NAME):$(IMAGE_TAG)