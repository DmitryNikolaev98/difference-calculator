[![Actions Status](https://github.com/DmitryNikolaev98/java-project-lvl2/workflows/hexlet-check/badge.svg)](https://github.com//java-project-lvl2/actions)
[![build](https://github.com/DmitryNikolaev98/java-project-lvl2/actions/workflows/main.yml/badge.svg)](https://github.com/DmitryNikolaev98/java-project-lvl2/actions/workflows/build-check.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/886e5f1e4965ba34772a/maintainability)](https://codeclimate.com/github/DmitryNikolaev98/java-project-lvl2/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/886e5f1e4965ba34772a/test_coverage)](https://codeclimate.com/github/DmitryNikolaev98/java-project-lvl2/test_coverage)

# Вычислитель отличий
Вычислитель отличий – программа, определяющая разницу между двумя структурами данных.
Возможности утилиты:
* Поддержка разных входных форматов: yaml и json
* Генерация отчета в виде plain text, stylish и json

## Пример использования

```bash
### формат plain
./app --format plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

### формат stylish
./app filepath1.json filepath2.json

{
  + follow: false
  + numbers: [1, 2, 3]
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {key=value}
  + setting4: blah blah
}
```


## Create build

```bash
make build
```

## Testing

To launch your application's tests, run:

```bash
make report
```

## Clear config

```bash
make clear
```
