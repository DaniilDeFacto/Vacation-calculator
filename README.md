### Tests and linter status:
[![Java CI](https://github.com/DaniilDeFacto/Vacation-calculator/actions/workflows/main.yml/badge.svg)](https://github.com/DaniilDeFacto/Vacation-calculator/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/bd89bd27bda8f164d757/maintainability)](https://codeclimate.com/github/DaniilDeFacto/Vacation-calculator/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/bd89bd27bda8f164d757/test_coverage)](https://codeclimate.com/github/DaniilDeFacto/Vacation-calculator/test_coverage)
# Vacation calculator
Данный проект является результатом выполнения следующего тестового задания:

"Приложение "Калькулятор отпускных".
Микросервис на SpringBoot + Java 11 c одним API:
GET "/calculacte"

Минимальные требования: Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.

Проверяться будет чистота кода, структура проекта, название полей\классов, правильность использования паттернов. Желательно написание юнит-тестов, проверяющих расчет."

### Приложение задеплоино по [ссылке](https://vacation-calculator.onrender.com)

Были выполнены все поставленные задачи. Приложение принимает необходимые данные в качестве соответствующих параметров запроса.

Могут приниматься запросы без указания точных дней ухода в отпуск в формате:

`http://localhost:8080/calculate?averageSalary=80000&vacationDays=14`

Так же принимаются запросы с указанием точных дней ухода в отпуск в формате:

`http://localhost:8080/calculate?averageSalary=50000&vacationDays=5&vacationDates=10.06.2024&vacationDates=11.06.2024&vacationDates=12.06.2024&vacationDates=13.06.2024&vacationDates=14.06.2024`

### Start

```bash
make start
```

### Build

```bash
make build
```

### Run

```bash
make run
```

### Run tests

```bash
make test
```

### Run checkstyle

```bash
make lint
```