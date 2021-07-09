docker run -d -p 27017:27017 --name mongo-shpl --env MONGO_INITDB_ROOT_USERNAME=shpl --env MONGO_INITDB_ROOT_PASSWORD=shpl mongo
docker cp catalog.json mongo-shpl:/
docker exec -it mongo-shpl mongoimport --uri mongodb://shpl:shpl@localhost:27017/?authSource=admin --collection=catalog --db=catalog --file=catalog.json --jsonArray
