#!/bin/bash

docker-compose --env-file test.env rm -f -s -v
docker-compose --env-file test.env up -d --wait
#docker-compose --env-file test.env logs
