###Задача на алгоритмы №2.

Есть файл с большим количеством строчек. Иногда в тексте встречаются сисечки, типа таких (((.)(.))). Скобочки в этой строке должны быть сбалансированы, то есть приведенная ранее строка является допустимой, а строка (((.)(.)) такой не является, потому что не равно количество открывающих и закрывающих скобок. Требуется написать функцию, которая найдет в файле все нормальные сисечки и выведет результаты на экран (например в консоль)

**Подведение итогов:** 31.03.2017г.

**Язык программирования:** Groovy.

**Критерии оценки:**
1. Корректность результата.
2. Время выполнения.

**Шаблон вывода:**

№ строка количество

Пример вывода:

1 (.)(.) 3

2 (((.)(.))) 6

3 ((.)(.)) 2


####Файлы в задаче:
* text.txt - файл с текстом, который нужно парсить.
* res.json - файл в котором кранится ответ на задачу. Объект с перечислением корректных вхождений и их колличества.
* textGen.js - генератор файла задания и файла ответа.
* answers - папка в которую нужно добавлять ответы.
