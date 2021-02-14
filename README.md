**Запуск тестового набора:**

открываем терминал и в папке проекта и выполняем команду:

`./gradlew -Pbrowser=chrome -Ptarget=remote clean testEmail`

передаваемые параметры:

`-Pbrowser` – желаемый браузер: firefox, googlechrome (дефолтный googlechrome)

`-Ptarget` – указание файла проперти (дефолтный local)

`-Dfile.encoding=UTF-8` – для правильного отображения кириллицы из файла json

`testEmail` – запускаемый тестовый набор

чтобы запустить тестовый набор с дефолтными настройками команда выглядит так:
 
 `./gradlew clean testEmail`

**Генерация отчета:**

после выполнения теста выполнить команду:

`allure generate allure-results --clean -o allure-report`

открыть отчет в браузере: 

`allure open`

очистить отчеты:

`rm -r allure-results/ allure-report || true`

