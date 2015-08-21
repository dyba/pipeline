#!/bin/bash

mkdir -p data/postgres
initdb data/postgres
# postgres -D data/postgres
# createuser --no-password pipeline
# createdb -O pipeline pipeline-dev
