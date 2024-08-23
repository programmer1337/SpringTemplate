# SpringTemplate

## Сборка
Собрать JAR-файл готового проекта через gradle wrapper с помощью `./gradlew bootJar` \
После этого конфигурируем Dockerfile для сборки Docker образа.
В моей реализации необходимо прокинуть JAR-файл при сборке проекта. \
Используя команду
```bash
  docker build --build-arg JAR_FILE="./build/libs/spring-template-0.0.1-SNAPSHOT.jar" -t  spring-template:0.0.1 .
  ```
- `--build-arg` - аргументы, в данном случае JAR_FILE, полученный после сборки.
- `-t` - позволяет указать имя образа и версионную метку для него. `image_name:tag`

<strong>Версию можно поменять в build.gradle файле</strong>

Готовый образ добавить в docker-compose файл, сконфигурировав всё для нового image.

### После этого запускаем

<strong>Для работы контейнера в фоновом режиме нужно дописать флаг -d (доступна работа с консолью).</strong>

Для запуска конкретного сервиса без зависимостей, в отдельном контейнере.
```bash
  docker compose run -rm [service-name] [options]
  ```
Для запуска конкретного сервиса с зависимостями.
```bash
  docker compose up -d [service-name]
  ```
Для запуска всех контейнеров и сервисов.
```bash
  docker compose up -d
  ```

## Docker команды
### Работа с Docker'ом

Остановить все запущенные контейнеры
```bash
  docker stop $(docker ps -q)
  ```
Удалить все контейнеры
```bash
  docker rm $(docker ps -a -q)
  ```
Удалить все образы
```bash
  docker rmi $(docker images -q)
  ```
Удалить все тома
```bash
  docker volume rm $(docker volume ls -q)
  ```

### Работа с внутренностями контейнера
Для подключени к контейнеру используем слудеющую команду
```bash
  docker exec -it [container_hash]
  ```
- `docker exec` - выполнение команды внутри контейнера
- `-it` - два флага `-i` (--interactive) запуск контейнера в интерактивном режиме, `-t` (--terminal) подключить терминал \

### Пример. Подключение к контейнеру базы данных Postgres.
```bash
  docker exec [container_hash] -it  psql -U booksUser -d books
  ```

# Кладовка

## Доступы
<strong>Указаны в docker-compose</strong>

## Порты
<strong>Traefik:</strong> 8080 \
<strong>Postgres:</strong> 5432 (default) \
<strong>Pgamdin:</strong> 80
