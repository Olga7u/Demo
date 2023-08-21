**Запускаем run hello-world**
![hello-world](img\hello-world.png)

**Размер образа hello-world**
![hello-world-size](img\hello-world-size.png)

**Все контейнеры, запущенных нет**
![ps](img\ps.png)

**Запускаем ubuntu**
![ubuntu](img\ubuntu.png)

**Проверяем, запущен ли ubuntu**
![ubuntu_check](img\ubuntu_check.png)

**Смотрим на файловую систему**\
**Переходим в home**\
**Создаём каталог test**
![ls_test](img\ls_test.png)

**Выходим из ubuntu**\
**Снова запускаем, переходим в home**

**Каталога test нет, при остановке контейнера внесённые изменения не сохраняются**
![ubuntu_stop](img\ubuntu_stop.png)

**Разворачиваем postgres**
![postgre13](img\postgre13.png)

**Подключаемся к базе данных**
![postgre13_connect](img\postgre13_connect.png)

**Создаём таблицу**
![create_table](img\create_table.png)

**Посмотрим, что внутри**
![select](img\select.png)

**Выходим из контейнера и удаляем его**
![postgre_gone](img\postgre_gone.png)

**Снова разворачиваем postgres**
![postgre_again](img\postgre_again.png)

**Подключаемся к базе данных через тот же connect**\
**И таблицы tTestDoc там больше нет, потому что мы удалили контейнер**
![no_table](img\no_table.png)

**Останавливаем контейнер postgres**
![postgre_exit](img\postgre_exit.png)