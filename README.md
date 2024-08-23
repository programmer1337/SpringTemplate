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
- `-t` - позволяет указать имя образа и тег версии для него. `image_name:tag`

<strong>Версию можно поменять в build.gradle файле</strong>

Готовый образ добавить в docker-compose при необходимости, сконфигурировав всё для нового image в compose файле.

## Docker команды
### Работа с сущностями Docker'а

<strong>Для работы контейнера в фоновом режиме нужно дописать флаг -d (доступна работа с консолью).</strong>

- Для запуска конкретного сервиса без зависимостей, в отдельном контейнере. \
При наличии `-rm` после остановки контейнер уничтожится. При наличии options будет перебита конфигурация, прописанная в docker-compose.

```bash
  docker compose run [-rm] [service-name] [options]
  ```
- Для запуска конкретного сервиса с зависимостями.
```bash
  docker compose up -d [service-name]
  ```
- Для запуска всех контейнеров и сервисов.
```bash
  docker compose up -d
  ```
- Остановить все запущенные контейнеры
```bash
  docker stop $(docker ps -q)
  ```
- Удалить все контейнеры
```bash
  docker rm $(docker ps -a -q)
  ```
- Удалить все образы
```bash
  docker rmi $(docker images -q)
  ```
- Удалить все тома
```bash
  docker volume rm $(docker volume ls -q)
  ```

### Работа с содержимым контейнера
Для подключения к контейнеру используем следующую команду
```bash
  docker exec -it [container_hash] container command [ARG...]
  ```
- `docker exec` - выполнение команды внутри контейнера
- `-it` - два флага `-i` (--interactive) запуск контейнера в интерактивном режиме, `-t` (--terminal) подключение терминала
- `container command` - команда для исполнения в терминале контейнера
- `ARG...` - один или более аргументов для использования внутри контейнера

### Пример. Подключение к контейнеру базы данных Postgres
```bash
  docker exec -it [container_hash] psql -U booksUser -d books
  ```

# Кладовка

## Доступы
<strong>Указаны в docker-compose</strong>

## Порты
<strong>Traefik:</strong> 8080 \
<strong>Postgres:</strong> 5432 (default) \
<strong>Pgadmin:</strong> 80
